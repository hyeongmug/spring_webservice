package com.skygudanr.webservice.service;

import com.skygudanr.webservice.domain.posts.PostsRepository;
import com.skygudanr.webservice.dto.posts.PostsMainResponseDto;
import com.skygudanr.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true) // (readOnly = true) => 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new) // 람다식으로써 .map(posts -> new PostsMainResponseDto(posts))와 동일
                .collect(Collectors.toList());
    }
}
