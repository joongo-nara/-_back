package com.example.minsuck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화 (생성/수정 시간 자동 기록)
@SpringBootApplication
public class MinsuckApplication {
    public static void main(String[] args) {
        SpringApplication.run(MinsuckApplication.class, args);
    }
}