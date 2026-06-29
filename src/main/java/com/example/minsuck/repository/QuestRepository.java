package com.example.minsuck.repository;

import com.example.minsuck.domain.Quest;
import com.example.minsuck.domain.QuestCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {
    List<Quest> findByCategory(QuestCategory category);
}