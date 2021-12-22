package com.skygudanr.webservice.domain.posts;


import com.skygudanr.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
@NoArgsConstructor
기본생성자 자동 추가
access = AccessLevel.PROTECTED : 기본생성자의 접근 권한을 protected로 제한
생성자로 protected Posts() {}와 같은 효과
Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는것은 허용하기 위해 추가
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
/*
@Entity
테이블과 링크될 클래스임을 나타냄.
언더스코어 네이밍 (_)으로 이름을 매칭.
ex) SALES_MANAGER 테이블
 */
@Entity
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK를 나타냄
    /*
    @GeneratedValue
    PK의 생성규칙을 나타냄
    기본값은 AUTO 로, MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 됨
    스프링 부트 2.0에선 ==> 옵션을 추가해줘야 auto_increment가 된다.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    /*
    @Column
    굳이 선언하지 않아도 됨
    기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용
    문자열의 경우 VARCHAR(255)가 기본값이라서 사이즈를 500으로 늘리고 싶거나, 타입을 TEXT로 변경하고 싶거나 등의 경우에 사용
     */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    @Builder
    해당 클래스의 빌더패턴 클래스를 생성
    생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    */
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    /*
        발더패턴 클래스 사용 ex)
        Posts.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();


        ===> 빌더패턴 설명 https://using.tistory.com/71
     */
}
