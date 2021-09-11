//관심 상품 테이블
package com.sparta.week04.models;

import com.sparta.week04.models.ProductRequestDto;
import com.sparta.week04.models.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Product extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice; //사용자가 직접 설정한 가격보다 lprice가 낮으면 최저가 딱지가 뜨는 기능 위해 지정

    //관심 상품을 등록하려면 관심 상품 관련된 정보를 들고오는 productRequestDto가 전달이 되려면 Product클래스(생성자)만들어야 함.
    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getPrice();
        this.image = requestDto.getImage();
        //1. 관심 상품의 가격 설정을 안하고 등록을 할 경우 : 최저가 딱지가 붙으면 안됨.( ==> 기본적으로 myprice가 가장 작으면 됨)
        //2. 사용자가 지정한 가격 < 현재 가격 --> 최저가 딱지
        this.myprice = 0;
    }

    public void updateByItemDto(ItemDto itemDto) {
        this.lprice = itemDto.getLprice();
    } //스케줄러에 의한 최저가 업데이트

    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }


}
