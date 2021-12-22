package com.skygudanr.webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    /*
    Entity 클래스와 거의 유사한 형태임에도 DTO 클래스를 생성.
    이유) 테이블과 매핑되는 Entity 클래스를 Request, Response 클래스로 사용해서는 안되기 때문.
        => Entity 클래스는 가장 Core한 클래스!
        => Request, Response용 DTO는 View를 위한 클래스.
     */
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
