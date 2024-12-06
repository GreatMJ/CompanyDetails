package com.example.CompanyDetails.dto.request;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyRequest {

    @NotBlank(message = "Company name is required")
    @Size(min = 5, message = "Company name must be atleast 5 characters long.")
     String name;

    @NotBlank(message = "email is required")
    @Email(message = "Not valid email id")
    String email;


    String code;

    @NotNull(message = "Strength is required")
    @PositiveOrZero(message = "Should be greater than equal zero")
     Integer strength;

    @NotBlank(message = "City is required")
     String city;

   @NotBlank(message = "State is required")
   String state;

   String website;


}
