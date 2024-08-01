package com.example.starwars.infrastructure.service;

import com.example.starwars.domain.Repository.ApiService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Component
public class SpeedCalculatorService {
    private final ApiService apiService;

    public SpeedCalculatorService(ApiService apiService) {
        this.apiService = apiService;
    }

    public <T> Integer getMaxSpeed(List<String> urls, Class<T> type, Function<T, Integer> speedExtractor) {
        return urls.stream()
                .map(url -> apiService.fetchObject(url, type))
                .filter(Objects::nonNull)
                .map(speedExtractor)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public <T> String getFastestName(List<String> urls, Class<T> type, Integer maxSpeed,
                                     Function<T, Integer> speedExtractor, Function<T, String> nameExtractor) {
        return urls.stream()
                .map(url -> apiService.fetchObject(url, type))
                .filter(obj -> obj != null && speedExtractor.apply(obj).equals(maxSpeed))
                .map(nameExtractor)
                .findFirst()
                .orElse("None");
    }


    //quiza no es necesario
    @FunctionalInterface
    public interface SpeedExtractor<T> {
        Integer extractSpeed(T obj);
    }

    @FunctionalInterface
    public interface NameExtractor<T> {
        String extractName(T obj);
    }
}
