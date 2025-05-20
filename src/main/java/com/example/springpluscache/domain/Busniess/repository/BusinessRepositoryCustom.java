package com.example.springpluscache.domain.Busniess.repository;


import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearchRequest;
import com.example.springpluscache.domain.Busniess.entity.Business;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BusinessRepositoryCustom {
    Page<Business> search(BusinessSearchRequest search, Pageable pageable);
}