package com.example.springpluscache.common.paging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PageResponse<T> {
    private List<T> businesses = new ArrayList<>();
    private PageInfo pageInfo;

    @JsonCreator
    public PageResponse(
            @JsonProperty("businesses") List<T> businesses,
            @JsonProperty("pageInfo") PageInfo pageInfo) {
        this.businesses.addAll(businesses);
        this.pageInfo = pageInfo;
    }

    public static <T> PageResponse<T> from(Page<T> page) {
        return new PageResponse<>(
                page.getContent(),
                new PageInfo(page.getNumber() + 1, page.getSize(), page.getTotalElements(), page.getTotalPages())
        );
    }
}