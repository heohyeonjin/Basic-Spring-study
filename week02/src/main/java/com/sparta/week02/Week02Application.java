package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing //Timestamped 반영되기 위함 annotation
@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {

            //JPA 사용법 임의로 작성해봄 ( 실제로 이렇게 사용 안함)
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영")); //db에 저장
            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll(); //db모든 내용 보여줌
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            // 변경할(update) 데이터를 물고다녀야 하기때문에 DTO에 값 저장해야함
            CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, requestDto); //db 업데이트
            courseList = courseRepository.findAll();
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            // 데이터 하나 조회하기
//            Course course = courseRepository.findById(1L).orElseThrow(
//                    ()-> new NullPointerException("아이디가 존재하지 않습니다.")
//            );

            // courseRepository.deleteAll();
        };
    }
}

