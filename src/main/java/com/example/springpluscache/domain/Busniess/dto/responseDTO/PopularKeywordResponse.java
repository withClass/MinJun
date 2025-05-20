package com.example.springpluscache.domain.Busniess.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PopularKeywordResponse {
    private final int rank;
    private final String keywords;
}
