package com.example.CompanyDetails.dto.response;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CompanyResponse {


    String name;
    String email;

    String code;
    Integer strength;
    String city;
    String state;
    String website;
    LocalDateTime createdTime;
}
