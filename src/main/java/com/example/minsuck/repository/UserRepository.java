package com.example.minsuck.repository;

import com.example.minsuck.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // 특정 부대(1중대 등) 소속 유저들을 레벨 내림차순, 경험치 내림차순으로 정렬하여 조회 (랭킹용)
    List<User> findByMilitaryUnitOrderByLevelDescCurrentExpDesc(String militaryUnit);

    // 전체 랭킹 조회용 (전체 부대 대상)
    List<User> findAllByOrderByLevelDescCurrentExpDesc();
}