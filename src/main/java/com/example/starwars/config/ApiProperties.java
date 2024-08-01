package com.example.starwars.config; // Asegúrate de que este paquete esté bajo el paquete raíz

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "api")
public class ApiProperties {
    private String url;

}
