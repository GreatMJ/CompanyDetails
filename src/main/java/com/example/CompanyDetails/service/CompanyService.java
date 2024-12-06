package com.example.CompanyDetails.service;

import com.example.CompanyDetails.Exception.ResourseNotFoundException;
import com.example.CompanyDetails.Transformers.CompanyTransformer;
import com.example.CompanyDetails.dto.request.CompanyRequest;
import com.example.CompanyDetails.dto.request.UpdateCompanyRequest;
import com.example.CompanyDetails.dto.response.CompanyResponse;
import com.example.CompanyDetails.models.Company;
import com.example.CompanyDetails.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    //method to add company details

    public void addRecord(CompanyRequest companyRequest){
        // validate the code
        String code=companyRequest.getCode();
        boolean isCodeValid=code==null?true:validateCode(code);

        if(!isCodeValid) throw new IllegalArgumentException("Code is not valid");

        // now create company record
        Company company= CompanyTransformer.requestToEntity(companyRequest);
        companyRepository.save(company);

    }

    private boolean validateCode(String code){
    // length should be 5 chars long
        if(code==null||code.length()!=5) return false;
        // Regular expression for validation
        String regex = "^[a-zA-Z]{2}[0-9]{2}[eEnN]$";
        return code.matches(regex);
    }


    // method to get the company records by state and city

    public List<CompanyResponse> getCompanyByCityAndState(String city,String state){
        List<Company> companies=companyRepository.findByCityAndState(city,state);

        if(companies==null||companies.isEmpty()) throw  new ResourseNotFoundException("No data found.");
        List<CompanyResponse> companyResponseList=new ArrayList<>(companies.size());
        for(Company company:companies){
            CompanyResponse companyResponse=CompanyTransformer.entityToResponse(company);
            companyResponseList.add(companyResponse);
        }
        return companyResponseList;
    }

    // method to update company
    public String updateCompanyById(Long id, UpdateCompanyRequest updateCompanyRequest){
        Company company=companyRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("Id is not valid"));

        // update company
        company.setName(updateCompanyRequest.getName());
        return "Company updated successfully!";
    }
}
