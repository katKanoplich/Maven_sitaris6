package com.example.strategy;

import com.example.maven.Game;

import java.util.List;

public class PromocodePriceStrategy implements PriceCalculateStrategy{
    @Override
    public float calculatePrice(List<Game> games) {
        float totalPrice = 0.0f;
        float promoPrice = 0.0f;
        for (Game game : games) {
            totalPrice += game.getPrice();
            promoPrice = totalPrice - totalPrice*0.1f;
        }
        return promoPrice;
    }
}
