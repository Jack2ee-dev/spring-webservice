package com.jack2ee.webservice.service;

import com.jack2ee.webservice.domain.posts.PostsRepository;
import com.jack2ee.webservice.dto.PostsMainResponseDto;
import com.jack2ee.webservice.dto.PostsSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
            .map(PostsMainResponseDto::new)
            .collect(Collectors.toList());
    }
}
