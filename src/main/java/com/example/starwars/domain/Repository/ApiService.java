package com.example.starwars.domain.Repository;

public interface ApiService {
    <T> T fetchObject(String url, Class<T> type);
}
