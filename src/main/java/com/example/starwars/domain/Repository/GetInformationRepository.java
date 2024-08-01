package com.example.starwars.domain.Repository;

import com.example.starwars.domain.Model.Information;

public interface GetInformationRepository {
  Information getInformation(String name);
}
