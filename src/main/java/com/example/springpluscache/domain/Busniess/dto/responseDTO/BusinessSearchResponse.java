package com.example.springpluscache.domain.Busniess.dto.responseDTO;

import com.example.springpluscache.domain.Busniess.entity.Business;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessSearchResponse {
    private String businessName;
    private String industryName;
    private String roadAddress;

    public static BusinessSearchResponse from(Business business) {
        return BusinessSearchResponse.builder()
                .businessName(business.getBusinessName())
                .industryName(business.getIndustryName())
                .roadAddress(business.getRoadAddress())
                .build();
    }
}
