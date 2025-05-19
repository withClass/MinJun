package com.example.springpluscache.domain.Busniess.controller;

import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearch;
import com.example.springpluscache.domain.Busniess.entity.Business;
import com.example.springpluscache.domain.Busniess.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/businesses")
public class BusinessController {

    private final BusinessService businessService;

    @GetMapping("/search")
    public Page<Business> searchV1(BusinessSearch search, Pageable pageable) {
        return businessService.searchV1(search, pageable);
    }
}
