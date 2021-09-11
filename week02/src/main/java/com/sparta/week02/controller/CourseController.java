package com.sparta.week02.controller;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //Json으로 응답을 해야하므로
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    // Post방식으로 이 주소로 오면, 해당 메소드가 실행된다.
    @PostMapping("/api/courses") //생성
    public Course createCourse(@RequestBody CourseRequestDto requestDto) { //생성한 Course 반환
        //  @RequestBody : 요청을 받는 거라는 표시 . 이게 없으면 요청한 정보가 requestDto안에 안들어감
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 course에서 새로운 생성자를 만듭니다.
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }

    //localhost:8080/api/courses 주소로 GET방식으로 데이터 조회 요청이 오면
    @GetMapping("/api/courses") //조회
    public List<Course> getCourses() {
        return courseRepository.findAll(); //이 메서드를 실행해라.
    } //--> 그럴라면 courseRepository 클래스가 필요 하므로 final주고 lombok설정

    //{id} : id 값이 유동적이다.
    @PutMapping("/api/courses/{id}") //수정
    //변경할 id, 변경할 내용
    //@PathVariable : id가 {id}에서 온 값임을 알려줌
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }

    @DeleteMapping("/api/courses/{id}") //삭제
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }
}