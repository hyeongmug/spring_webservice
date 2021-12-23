package com.skygudanr.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

/*
보통 ibatis/MyBatis 등에서 Dao라고 불리는 DB Layer 접근자
JPA에선 Repository라고 부르며 인터페이스로 생성
단순히 인터페이스 생성후, JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인 CRUD메소드가 자동 생성됨
@Repository를 추가할 필요도 없음
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

    /*
    실제로 위 코드는 SpringDataJpa에서 제공하는 기본 메소드만으로 해결할 수 있다.
    굳이 @Query를 쓴 이유는, SpringDataJpa에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해도 되는것을 보여주기 위함이다.
    */
}
