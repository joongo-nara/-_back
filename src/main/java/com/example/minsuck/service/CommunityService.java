package com.example.minsuck.service;

import com.example.minsuck.DTO.CommunityDto.*;
import com.example.minsuck.domain.*;
import com.example.minsuck.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostResponse> getFeeds(int page, int size) {
        return postRepository.findAllByOrderByCreatedAtDesc(PageRequest.of(page - 1, size))
                .stream().map(p -> new PostResponse(p.getId(), p.getUser().getNickname(), p.getUser().getRank(), p.getUser().getClassType(), p.getContent(), p.isAutoPosted(), p.getLikesCount()))
                .collect(Collectors.toList());
    }

    public CreatePostResponse createPost(Long userId, String content) {
        Post post = Post.builder().user(userRepository.findById(userId).orElseThrow()).content(content).isAutoPosted(false).build();
        postRepository.save(post);
        return new CreatePostResponse(true, post.getId());
    }
}