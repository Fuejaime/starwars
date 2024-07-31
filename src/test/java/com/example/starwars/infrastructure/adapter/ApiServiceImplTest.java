package com.example.starwars.infrastructure.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApiServiceImplTest {

    @InjectMocks
    private ApiServiceImpl underTest;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Init mocks
    }

    @Test
    void fetchObject() {
        // Arrange
        String url = "http://example.com/api/resource";
        String expectedResponse = "Test Response";
        when(restTemplate.getForObject(eq(url), eq(String.class)))
                .thenReturn(expectedResponse);

        // Act
        String response = underTest.fetchObject(url, String.class);

        // Assert
        assertEquals(expectedResponse, response);
        verify(restTemplate).getForObject(eq(url), eq(String.class));
    }

}
