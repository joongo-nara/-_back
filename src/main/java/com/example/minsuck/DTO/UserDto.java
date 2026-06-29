package com.example.minsuck.DTO;

import java.util.Map;

public class UserDto {
    public record UserProfileResponse(String nickname, String rank, int level, int currentExp, int maxExp, Map<String, Integer> stats, boolean isAdmin) {}

    public record BuddyJoinRequest(String connectionPin) {}
    public record BuddyJoinResponse(boolean success, Long buddyGroupId) {}

    public record TitleEquipRequest(Long titleId) {}
    public record TitleEquipResponse(boolean success, String equippedTitle) {}
}