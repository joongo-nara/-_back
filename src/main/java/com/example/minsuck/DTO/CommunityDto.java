package com.example.minsuck.DTO;

public class CommunityDto {
    public record PostResponse(Long postId, String nickname, String rank, String classType, String content, boolean isAuto, int likes) {}

    public record CreatePostRequest(String content) {}
    public record CreatePostResponse(boolean success, Long postId) {}

    public record LikeResponse(boolean success, int currentLikes) {}

    public record CreateCommentRequest(String content) {}
    public record CreateCommentResponse(boolean success, Long commentId) {}
}