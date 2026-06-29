package com.example.minsuck.controller;

import com.example.minsuck.DTO.CommunityDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class CommunityController {
    @GetMapping
    public ResponseEntity<List<PostResponse>> getPosts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(List.of(new PostResponse(1L, "고차원", "일병", "[운전병]", "[알림] 퀘스트 완료", true, 12)));
    }

    @PostMapping
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest request) {
        return ResponseEntity.ok(new CreatePostResponse(true, 2L));
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<LikeResponse> toggleLike(@PathVariable Long id) {
        return ResponseEntity.ok(new LikeResponse(true, 13));
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<CreateCommentResponse> addComment(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        return ResponseEntity.ok(new CreateCommentResponse(true, 5L));
    }
}