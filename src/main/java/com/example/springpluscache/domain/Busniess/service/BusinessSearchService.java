package com.example.springpluscache.domain.Busniess.service;

import com.example.springpluscache.common.paging.PageResponse;
import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearchRequest;
import com.example.springpluscache.domain.Busniess.dto.responseDTO.BusinessSearchResponse;
import com.example.springpluscache.domain.Busniess.entity.Business;
import com.example.springpluscache.domain.Busniess.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessSearchService {

    private final BusinessRepository businessRepository;
    private final BusinessPopularSearchKeywordService popularKeywordService;

    // 🔍 검색 - DB 조회 (v1)
    public Page<BusinessSearchResponse> searchV1(BusinessSearchRequest search, Pageable pageable) {
        Page<Business> results = businessRepository.search(search, pageable);

        List<BusinessSearchResponse> dtoList = results.stream()
                .map(BusinessSearchResponse::from)
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, results.getTotalElements());
    }

    // 🔍 검색 - Redis Remote Cache (v2)
    @Cacheable(value = "businessSearchCache",
            key = "'search:' + #search.keyWords + ':page=' + #pageable.pageNumber + ':size=' + #pageable.pageSize + ':sort=' + #pageable.sort.toString()")
    public PageResponse<BusinessSearchResponse> searchV2(BusinessSearchRequest search, Pageable pageable) {
        Page<Business> results = businessRepository.search(search, pageable);

        if (!results.isEmpty() && search.getKeyWords() != null && !search.getKeyWords().isBlank()) {
            popularKeywordService.increaseKeywordCount(search.getKeyWords());
        }

        List<BusinessSearchResponse> dtoList = results.stream()
                .map(BusinessSearchResponse::from)
                .collect(Collectors.toList());

        // PageResponse의 생성자 대신 static from 메서드 사용
        return PageResponse.from(new PageImpl<>(dtoList, pageable, results.getTotalElements()));
    }

}