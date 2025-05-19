package com.example.springpluscache.domain.Busniess.repository;

import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearch;
import com.example.springpluscache.domain.Busniess.entity.Business;
import com.example.springpluscache.domain.Busniess.entity.QBusiness;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class BusinessRepositoryImpl implements BusinessRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Business> search(BusinessSearch search, Pageable pageable) {
        QBusiness b = QBusiness.business;

        BooleanBuilder builder = buildSearchConditions(search, b);

        List<Business> results = queryFactory
                .selectFrom(b)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(b.count())
                .from(b)
                .where(builder);

        return PageableExecutionUtils.getPage(results, pageable, countQuery::fetchCount);
    }

    private BooleanBuilder buildSearchConditions(BusinessSearch search, QBusiness b) {
        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.hasText(search.getBusinessName())) {
            builder.and(b.businessName.containsIgnoreCase(search.getBusinessName()));
        }
        if (StringUtils.hasText(search.getIndustryName())) {
            builder.and(b.industryName.containsIgnoreCase(search.getIndustryName()));
        }
        if (StringUtils.hasText(search.getRoadAddress())) {
            builder.and(b.roadAddress.containsIgnoreCase(search.getRoadAddress()));
        }

        return builder;
    }
}