package com.example.strategy;

import com.example.maven.Game;

import java.util.List;

public class TotalPriceStrategy implements PriceCalculateStrategy{
    @Override
    public float calculatePrice(List<Game> games) {
        float totalPrice = 0.0f;
        for (Game game : games) {
            totalPrice += game.getPrice();
        }
        return totalPrice;
    }
}
