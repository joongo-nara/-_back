package com.example.minsuck.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 10)
    private String rank;

    @Column(nullable = false, length = 20)
    private String militaryUnit;

    private LocalDate dischargeDate;

    @Column(nullable = false, length = 20)
    private String classType;

    private int level = 1;
    private int currentExp = 0;
    private int maxExp = 1000;

    // 관리자 권한 토글 (기본값 false)
    @Column(nullable = false)
    private boolean isAdmin = false;

    @Embedded
    private CharacterStats stats = new CharacterStats();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buddy_group_id")
    private BuddyGroup buddyGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipped_title_id")
    private Title equippedTitle;

    @Builder
    public User(String nickname, String rank, String militaryUnit, String classType, LocalDate dischargeDate) {
        this.nickname = nickname;
        this.rank = rank;
        this.militaryUnit = militaryUnit;
        this.classType = classType;
        this.dischargeDate = dischargeDate;
    }
}