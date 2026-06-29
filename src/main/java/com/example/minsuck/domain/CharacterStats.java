package com.example.minsuck.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class CharacterStats {
    private int strength = 0;
    private int stamina = 0;
    private int intelligence = 0;
    private int mental = 0;
    private int survival = 0;
}