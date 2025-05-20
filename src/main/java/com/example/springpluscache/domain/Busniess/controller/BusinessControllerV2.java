package com.example.springpluscache.domain.Busniess.controller;

import com.example.springpluscache.common.paging.PageResponse;
import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearchRequest;
import com.example.springpluscache.domain.Busniess.dto.responseDTO.BusinessSearchResponse;
import com.example.springpluscache.domain.Busniess.dto.responseDTO.PopularKeywordResponse;
import com.example.springpluscache.domain.Busniess.service.BusinessPopularSearchKeywordService;
import com.example.springpluscache.domain.Busniess.service.BusinessSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/businesses")
public class BusinessControllerV2 {

    private final BusinessSearchService businessSearchService;
    private final BusinessPopularSearchKeywordService businessPopularSearchKeywordService;

    // 검색 API
    @GetMapping("/search")
    public ResponseEntity<PageResponse<BusinessSearchResponse>> searchV2(BusinessSearchRequest search, Pageable pageable) {
        PageResponse<BusinessSearchResponse> response = businessSearchService.searchV2(search, pageable);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 인기 검색어 Top 10 조회 API
    @GetMapping("/popular-keywords")
    public ResponseEntity<List<PopularKeywordResponse>> getPopularKeywords() {
        List<PopularKeywordResponse> response = businessPopularSearchKeywordService.getPopularKeywordResponses(10);
        return ResponseEntity.ok(response);
    }
}