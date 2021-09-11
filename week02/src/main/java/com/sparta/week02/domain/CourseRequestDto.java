package com.sparta.week02.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter //정보를 물고 다니려면 정보 설정 필요
@RequiredArgsConstructor
public class CourseRequestDto { //Course에 관한 Data를 물고다니는 놈..

    //private String title;
    //private String tutor;
    // ** private으로 선언한 놈이 final로 선언이 되면 필요한 생성자 자동으로 만들어 줌
    private final String title;
    private final String tutor;

}
