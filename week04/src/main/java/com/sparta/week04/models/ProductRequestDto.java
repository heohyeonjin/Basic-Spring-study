// 관심 상품 등록하기
package com.sparta.week04.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//상품 생성과 관련 --> title, link, image, lprice 정보 가지고 다녀야 함.
public class ProductRequestDto {

    private String title;
    private String link;
    private String image;
    private int price;
}
