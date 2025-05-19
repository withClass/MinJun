package com.example.springpluscache.domain.Busniess.controller;

import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearch;
import com.example.springpluscache.domain.Busniess.entity.Business;
import com.example.springpluscache.domain.Busniess.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/businesses")
public class BusinessControllerV2 {

    private final BusinessService businessService;

    @GetMapping("/search")
    public Page<Business> searchV2(BusinessSearch search, Pageable pageable) {
        return businessService.searchV2(search, pageable);
    }
}