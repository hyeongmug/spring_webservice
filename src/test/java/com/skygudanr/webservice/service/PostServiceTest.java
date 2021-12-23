package com.skygudanr.webservice.service;

import com.skygudanr.webservice.domain.posts.PostsRepository;
import com.skygudanr.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("skygudanr@test.com")
                .content("테스트 내용 2")
                .title("테스트 제목 2")
                .build();
    }
}
