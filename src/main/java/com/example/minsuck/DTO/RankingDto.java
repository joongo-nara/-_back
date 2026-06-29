package com.example.minsuck.DTO;

public class RankingDto {
    public record RankingResponse(int rank, String nickname, String militaryRank, String unit, int level, int exp) {}
    public record PokeResponse(boolean success, String message) {}
}