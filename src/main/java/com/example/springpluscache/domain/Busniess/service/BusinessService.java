package com.example.springpluscache.domain.Busniess.service;

import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearch;
import com.example.springpluscache.domain.Busniess.entity.Business;
import com.example.springpluscache.domain.Busniess.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;

    public Page<Business> searchV1(BusinessSearch search, Pageable pageable) {
        return businessRepository.search(search, pageable);
    }
}