package com.example.springpluscache.common.paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private int page;
    private int pageSize;
    private long totalElements;
    private long totalPages;
}
