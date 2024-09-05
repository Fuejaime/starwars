package com.example.starwars.domain.Repository;

import org.springframework.stereotype.Component;

@Component
public interface ApiService {
    <T> T fetchObject(String url, Class<T> type);
}
