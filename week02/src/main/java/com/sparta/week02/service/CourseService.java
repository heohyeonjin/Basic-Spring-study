package com.sparta.week02.service;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// -> 꼭 필요한 멤버 변수를 final로 선언하고, 그 위에 RequiredArgsConstructor선언
@RequiredArgsConstructor //생성자 자동 생성
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시 (한번 값이 부여되면 변형 X)
    private final CourseRepository courseRepository; //Respository : 검색(find),업데이트 할때 필요 (SQL을 날려줘야 함)

    //
//    생성자를 통해서 CourseService 클래스를 사용하기 위해서 만들 때 꼭 Repository를 알아서 생성해서 멤버 변수에 넣어주도록 스프링에게 알려줌
//    public CourseService(CourseRepository courseRepository) { //생성자 메소드
//        this.courseRepository = courseRepository; --> 대신 @ReqiredArgsConstructor
//    }
    //Course클래스 안에 update 메서드를 만들고 해당 클래스 정보를 바꿔주면 그러면 그 정보가 자동으로 DB에 적용됨  --> Transactional덕분
    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    //update할 때 필요한 것 : update할 대상의 id, 업데이트 할 내용을 가진 정보
    public Long update(Long id, CourseRequestDto requestDto) { //course는 대신 다른거 들어와도 됨
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
}
