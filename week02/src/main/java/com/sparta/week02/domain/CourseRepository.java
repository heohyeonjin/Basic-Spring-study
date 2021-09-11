package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository - SQL 역할을 대신해주는 역할
//--> CourseRepository - Course에 관한 Repository

public interface CourseRepository extends JpaRepository<Course, Long> {
    // JpaRepository 기능을 가져와서 CourseRepository에서 쓸거야.(JPA)
    // <Course,Long> : Course class를 대상으로 , 식별하는 id의 형태는 Long이다
}
