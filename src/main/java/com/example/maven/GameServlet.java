package com.example.maven;

import com.example.strategy.PriceCalculateStrategy;
import com.example.strategy.PromocodePriceStrategy;
import com.example.strategy.TotalPriceStrategy;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {
    private PriceCalculateStrategy priceCalculateStrategy;

    public void setPriceCalculateStrategy(PriceCalculateStrategy priceCalculateStrategy) {
        this.priceCalculateStrategy = priceCalculateStrategy;
    }

    private float calculatePrice(List<Game> games) {
        return priceCalculateStrategy.calculatePrice(games);
    }

    private GameParser gameParser;
    @Override
    public void init() throws ServletException {
        gameParser = new GameParser();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String xmlFilePath = getServletContext().getRealPath("/WEB-INF/classes/games.xml");
        List<Game> games = gameParser.parseGame(xmlFilePath);
        TotalPriceStrategy totalPriceStrategy = new TotalPriceStrategy();
        PromocodePriceStrategy promocodePriceStrategy = new PromocodePriceStrategy();
        float totalPrice = totalPriceStrategy.calculatePrice(games);
        float promocodePrice = promocodePriceStrategy.calculatePrice(games);


        request.setAttribute("games", games);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("promocodePrice", promocodePrice);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/game.jsp");
        dispatcher.forward(request, response);

    }

}

