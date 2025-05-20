package com.example.springpluscache.domain.Busniess.repository;

import com.example.springpluscache.domain.Busniess.dto.requestDTO.BusinessSearchRequest;
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
    public Page<Business> search(BusinessSearchRequest search, Pageable pageable) {
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

    private BooleanBuilder buildSearchConditions(BusinessSearchRequest search, QBusiness b) {
        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.hasText(search.getKeyWords())) {
            String keyword = search.getKeyWords();
            builder.or(b.businessName.containsIgnoreCase(keyword));
            builder.or(b.industryName.containsIgnoreCase(keyword));
            builder.or(b.roadAddress.containsIgnoreCase(keyword));
        }

        return builder;
    }
}