package com.example.CompanyDetails.controller;

import com.example.CompanyDetails.dto.request.CompanyRequest;
import com.example.CompanyDetails.dto.request.UpdateCompanyRequest;
import com.example.CompanyDetails.dto.response.CompanyResponse;
import com.example.CompanyDetails.service.CompanyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/company")
@Validated
public class CompanyController {

@Autowired
    private CompanyService companyService;

    // add company details
    @PostMapping
    public ResponseEntity<Void> addDetails(@Valid @RequestBody CompanyRequest companyRequest){
        companyService.addRecord(companyRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public  ResponseEntity<List<CompanyResponse>> getCompanyByCityAndState(@NotBlank(message = "city is required") @RequestParam String city, @NotBlank(message = "state is required")@RequestParam String state){
        List<CompanyResponse> companyResponseList=companyService.getCompanyByCityAndState(city,state);
        return ResponseEntity.ok(companyResponseList);
    }

    @PutMapping
    public  ResponseEntity<String> updateCompanyById(@NotNull(message = "Id is required") @PathVariable Long id, @Valid @RequestBody UpdateCompanyRequest updateCompanyRequest){
        String res=companyService.updateCompanyById(id,updateCompanyRequest);
        return ResponseEntity.ok(res);
    }
}
