package com.example.springpluscache.domain.Busniess.controller;

import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearchRequest;
import com.example.springpluscache.domain.Busniess.dto.responseDTO.BusinessSearchResponse;
import com.example.springpluscache.domain.Busniess.entity.Business;
import com.example.springpluscache.domain.Busniess.service.BusinessSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/businesses")
public class BusinessController {

    private final BusinessSearchService businessSearchService;

    @GetMapping("/search")
    public ResponseEntity<Page<BusinessSearchResponse>> searchV1(BusinessSearchRequest search, Pageable pageable) {
        Page<BusinessSearchResponse> response = businessSearchService.searchV1(search, pageable);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
