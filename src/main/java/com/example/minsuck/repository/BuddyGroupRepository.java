package com.example.minsuck.repository;

import com.example.minsuck.domain.BuddyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BuddyGroupRepository extends JpaRepository<BuddyGroup, Long> {
    Optional<BuddyGroup> findByConnectionPin(String connectionPin);
}