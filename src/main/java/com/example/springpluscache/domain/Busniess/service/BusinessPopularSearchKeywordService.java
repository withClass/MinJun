package com.example.springpluscache.domain.Busniess.service;

import com.example.springpluscache.domain.Busniess.dto.responseDTO.PopularKeywordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BusinessPopularSearchKeywordService {

    private final StringRedisTemplate stringRedisTemplate;
    private static final String POPULAR_KEYWORD = "popularSearchKeyword";

    // 검색어 추이 증가
    public void increaseKeywordCount(String keyword) {
        stringRedisTemplate.opsForZSet().incrementScore(POPULAR_KEYWORD, keyword, 1);
    }

    // 인기 검색어와 점수 조회 (순수 데이터 반환)
    public Set<ZSetOperations.TypedTuple<String>> getPopularKeywordsWithScores(int topN) {
        return stringRedisTemplate.opsForZSet().reverseRangeWithScores(POPULAR_KEYWORD, 0, topN - 1);
    }

    // 랭킹과 DTO 변환
    public List<PopularKeywordResponse> getPopularKeywordResponses(int topN) {
        Set<ZSetOperations.TypedTuple<String>> tuples = getPopularKeywordsWithScores(topN);
        List<PopularKeywordResponse> result = new ArrayList<>();
        int rank = 1;
        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
            result.add(new PopularKeywordResponse(rank++, tuple.getValue()));
        }
        return result;
    }
}
