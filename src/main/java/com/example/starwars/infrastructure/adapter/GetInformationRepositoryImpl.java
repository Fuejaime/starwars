package com.example.starwars.infrastructure.adapter;

import com.example.starwars.domain.Model.Information;
import com.example.starwars.domain.Repository.GetInformationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetInformationRepositoryImpl implements GetInformationRepository {

  @Override
  public Information getInformation(String name) {
        return Information.builder().name(name).build();
  }
}
