package com.jack2ee.webservice.web;

import com.jack2ee.webservice.domain.posts.PostsRepository;
import com.jack2ee.webservice.dto.PostSaveRequestDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
/**
 * 생성자로 Bean 개체를 받도록 함
 **/
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
