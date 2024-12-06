package com.example.CompanyDetails.Transformers;

import com.example.CompanyDetails.dto.request.CompanyRequest;
import com.example.CompanyDetails.dto.response.CompanyResponse;
import com.example.CompanyDetails.models.Company;

import java.time.LocalDateTime;

public class CompanyTransformer {

    public  static Company requestToEntity(CompanyRequest companyRequest){
        return Company.builder()
                .city(companyRequest.getCity())
                .state(companyRequest.getState())
                .email(companyRequest.getEmail())
                .createdTime(LocalDateTime.now())
                .strength(companyRequest.getStrength())
                .name(companyRequest.getName())
                .code(companyRequest.getCode())
                .website(companyRequest.getWebsite())
                      .build();
    }

    public static CompanyResponse entityToResponse(Company company){
        return CompanyResponse.builder()
                .city(company.getCity())
                .name(company.getName())
                .website(company.getWebsite())
                .createdTime(company.getCreatedTime())
                .strength(company.getStrength())
                .state(company.getState())
                .code(company.getCode())
                .email(company.getEmail())
                .build();
    }
}
