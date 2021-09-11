package com.sparta.week04.controller;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;
    //@RequestParam : 요청할 때 파라미터(검색) 정보 받기 (?뒤에 있는게 파라미터),
    // 중요 : ?뒤의 변수명이랑 아래 변수명(query) 동일해야 함.
    @GetMapping("/api/search")
    public List<ItemDto> execSearch(@RequestParam String query){
        String result = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(result);
    }
}
