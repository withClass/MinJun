package com.example.springpluscache.domain.Busniess.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BusinessSearchRequest {
    @NotBlank(message = "검색어는 필수입니다.")
    @Size(min = 2, message = "검색어는 최소 2글자 이상이어야 합니다.")
    private String keyWords;
}
