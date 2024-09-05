package com.example.starwars.infrastructure.adapter;

import com.example.starwars.domain.Repository.ApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {
    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> T fetchObject(String url, Class<T> type) {
        return restTemplate.getForObject(url, type);
    }
}
