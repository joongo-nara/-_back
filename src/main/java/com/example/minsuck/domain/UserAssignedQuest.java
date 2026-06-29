package com.example.minsuck.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_assigned_quests")
public class UserAssignedQuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quest_id", nullable = false)
    private Quest quest;

    @Column(nullable = false)
    private LocalDate assignedDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestStatus status;

    // 리롤(새로고침) 여부 추가
    @Column(nullable = false)
    private boolean isRerolled = false;

    private LocalDateTime completedAt;

    public void completeQuest() {
        this.status = QuestStatus.COMPLETED;
        this.completedAt = LocalDateTime.now();
    }
}