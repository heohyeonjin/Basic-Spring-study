package com.sparta.week04.service;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductMypriceRequestDto;
import com.sparta.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    // 관심 가격 정보가 전달 되었을 때, 1.해당 id로 product를 찾고 2.해당 정보를 업데이트
    @Transactional //db정보 바꿀거다.
    public Long update(Long id, ProductMypriceRequestDto requestDto){
       Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
       product.update(requestDto);
       return id;
    }

    //스케줄러에 의해 상품 가격 변동 사항 업데이트트
   @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }
}
