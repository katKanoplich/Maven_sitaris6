package com.example.maven;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class GameParser {
    public List<Game> parseGame(String xmlFilePath){
        List<Game> games = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("file:///" + xmlFilePath);

            Element rootElement = document.getDocumentElement();
            NodeList gamesNodes = rootElement.getElementsByTagName("game");

            for (int i = 0; i < gamesNodes.getLength(); i++) {
                Element gameElement = (Element) gamesNodes.item(i);
                String id = gameElement.getElementsByTagName("id").item(0).getTextContent();

               // int id = Integer.parseInt(gameElement.getElementsByTagName("id").item(0).getTextContent());
                String name = gameElement.getElementsByTagName("name").item(0).getTextContent();
                float price = Float.parseFloat(gameElement.getElementsByTagName("price").item(0).getTextContent());
                String genre = gameElement.getElementsByTagName("genre").item(0).getTextContent();
                String platform = gameElement.getElementsByTagName("platform").item(0).getTextContent();
                int releaseYear = Integer.parseInt(gameElement.getElementsByTagName("releaseYear").item(0).getTextContent());
                String developer = gameElement.getElementsByTagName("developer").item(0).getTextContent();
                games.add(new Game(id, price, name, genre, platform, releaseYear, developer));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return games;
    }

}

