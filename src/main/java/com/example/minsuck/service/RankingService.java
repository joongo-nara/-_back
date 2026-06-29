package com.example.minsuck.service;

import com.example.minsuck.controller.RankingController.RankingResponse;
import com.example.minsuck.domain.User;
import com.example.minsuck.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RankingService {

    private final UserRepository userRepository;

    public List<RankingResponse> getRankingsByUnit(String unit) {
        List<User> users;
        if ("전체".equals(unit)) {
            users = userRepository.findAllByOrderByLevelDescCurrentExpDesc();
        } else {
            users = userRepository.findByMilitaryUnitOrderByLevelDescCurrentExpDesc(unit);
        }

        // 인덱스를 활용하여 순위(Rank) 부여
        return IntStream.range(0, users.size())
                .mapToObj(i -> {
                    User u = users.get(i);
                    return new RankingResponse(
                            i + 1, u.getNickname(), u.getRank(),
                            u.getMilitaryUnit(), u.getLevel(), u.getCurrentExp()
                    );
                }).collect(Collectors.toList());
    }
}