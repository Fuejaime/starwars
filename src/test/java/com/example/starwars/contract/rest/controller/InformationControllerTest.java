package com.example.starwars.contract.rest.controller;

import com.example.starwars.application.usecase.GetInformationUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class InformationControllerTest {

    @InjectMocks
    InformationController underTest;

    @Mock
    GetInformationUseCase getInformationUseCase;
/*
    @Test
    void getInfo() {
        String name = "Luke";
        String result = String.valueOf(this.underTest.getInfo(name));
        assertEquals("Info" + name, result);
    }*/
}
