package com.example.strategy;

import com.example.maven.Game;

import java.util.List;

public interface PriceCalculateStrategy {
    float calculatePrice(List<Game> games);
}