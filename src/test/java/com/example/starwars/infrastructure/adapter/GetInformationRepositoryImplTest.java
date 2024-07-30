package com.example.starwars.infrastructure.adapter;

import com.example.starwars.domain.Model.Information;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GetInformationRepositoryImplTest {

    @InjectMocks
    GetInformationRepositoryImpl underTest;

    @Test
    void getInformation() {
        String name = "Luke Skywalker";
        Information result = this.underTest.getInformation(name);
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(name);
    }
}
