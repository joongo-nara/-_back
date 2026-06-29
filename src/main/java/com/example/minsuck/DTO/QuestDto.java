package com.example.minsuck.DTO;

public class QuestDto {
    public record QuestResponse(Long questId, String title, String description, String status, int rewardExp) {}

    public record PinAuthRequest(String buddyPin) {}
    public record TextAuthRequest(String summary) {}

    public record QuestAuthResponse(boolean success, int earnedExp, String increasedStat, int statAmt) {}
}