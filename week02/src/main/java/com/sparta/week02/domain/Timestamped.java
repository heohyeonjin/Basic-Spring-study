package com.sparta.week02.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
//DB는 생성일자와 수정일자를 필드로 가지는 것이 기본중의 기본!

@MappedSuperclass // 상속했을 때, 컬럼으로 인식하게 합니다.
//이 클래스를 상속했을 때의 멤버변수도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // 생성/수정 시간을 자동으로 반영하도록 설정
//Entity(Table) 를 주시(Listener)하다가 수정이 일어날때 자동으로 반영해줘(AuditingEntityListener)
public abstract class Timestamped {
//Timstamped class는 createdAt, modifiedAt 멤버 두개를 가짐

    @CreatedDate // 생성일자임을 나타냅니다.
    private LocalDateTime createdAt;  //LocalDataTime : 시간을 나타내는 자바의 자료형

    @LastModifiedDate // 마지막 수정일자임을 나타냅니다.
    private LocalDateTime modifiedAt;
}

//abstract : 직접 구현 안된다. 상속으로만 쓸 수 있다.(extends Timestamped) --> new stamped 이런거 안됨