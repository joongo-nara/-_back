package com.example.minsuck.DTO;

import java.util.List;

public class AdminDto {
    public record AdminStatsResponse(int totalUsers, int completionRate, List<Integer> chartData) {}
    public record TopQuestResponse(String title, int count) {}

    public record InactiveUserResponse(Long userId, String nickname, String reason) {}

    public record WarnRequest(String messageType) {}
    public record WarnResponse(boolean success, String message) {}
}