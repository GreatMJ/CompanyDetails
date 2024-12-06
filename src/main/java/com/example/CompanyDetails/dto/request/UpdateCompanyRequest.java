package com.example.CompanyDetails.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCompanyRequest {
    @NotBlank(message = "Company name is required")
    @Size(min = 5, message = "Company name must be atleast 5 characters long.")
    String name;
}
