package com.example.starwars.application.usecase;

import com.example.starwars.domain.Model.Information;

public interface GetInformationUseCase {
  Information getInformation(String name);
}
