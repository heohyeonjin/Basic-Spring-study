//파일 순서 : Course , CourseRepository -> Timestamped -> 업데이트기능 위해 Service  --> update할라면 DTO 사용
//--> 이제 클라이언트와 가장 가까운 controller

package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 자동으로 생성해줍니다.(파라미터가 없다=기본생성자) 이거 없으면 new course1 이런거 안됨
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped { //Timestamped 상속
    //테이블 생성
    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.(=AUTO_INCREMENT)
    private Long id;

    @Column(nullable = false) // 컬럼(열) 값이고 반드시 값이 존재해야 함(nullable=false)을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

//    public Long getId(){ return this.id; }
//    public String getTitle() {
//        return this.title;
//    }
//    public String getTutor() {
//        return this.tutor;
//    }
//setter를 설정해주지 않는 이유 : Repository에서 자동으로 해주기 때문

    //CourseController에서 Postmapping을 할때 요청받은 값을 dto로 받아서 course로 저장해야 하기때문에 해당 생성자 필요
    public Course(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public void update(CourseRequestDto requestDto) { //course를 받았을 때 title,tutor 업데이트
// this.title  = course.title;
// this.tutor = course.tutor;
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}
