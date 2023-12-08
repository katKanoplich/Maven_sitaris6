import com.example.maven.*;
import com.example.strategy.TotalPriceStrategy;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestClass {
    private List<Game> games = new ArrayList<>();
    @Test
    public void testTotalPrice(){
        Game game1 = new Game("1",2, "WORLD OF TANKS","arcade","PC",2021,"Krid");
        Game game2 = new Game("2",2, "FIFA","sport","PC",2019,"Mol");
        games.add(game1);
        games.add(game2);
        TotalPriceStrategy totalPriceStrategy = new TotalPriceStrategy();
        assertEquals(4, totalPriceStrategy.calculatePrice(games) );
    }
    @Test
    public void parseXML(){
        try{
            File tempFile = File.createTempFile("test", ".xml");
            FileWriter writer = new FileWriter(tempFile);
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<games>\n");
            writer.write("  <game>\n");
            writer.write("    <id>1</id>\n");
            writer.write("    <name>FIFA</name>\n");
            writer.write("    <price>25</price>\n");
            writer.write("    <genre>SPORT</genre>\n");
            writer.write("    <platform>PC</platform>\n");
            writer.write("    <releaseYear>2014</releaseYear>\n");
            writer.write("    <developer>STEAM</developer>\n");
            writer.write("  </game>\n");
            writer.write("</games>\n");
            writer.close();

            // Вызываем тестируемый метод
            GameParser gameParser = new GameParser();
            games = gameParser.parseGame(tempFile.getAbsolutePath());
            // Проверяем результат
            assertEquals(1, games.size());
            assertEquals("1", games.get(0).getId());
            assertEquals("FIFA", games.get(0).getName());
            assertEquals(25, games.get(0).getPrice());
            assertEquals("SPORT", games.get(0).getGenre());
            assertEquals("PC", games.get(0).getPlatform());
            assertEquals(2014, games.get(0).getReleaseYear());
            assertEquals("STEAM", games.get(0).getDeveloper());

            // Удаляем временный файл
            tempFile.delete();
        }
        catch (Exception e){

        }


    }
    @Test
    public void  testGetterSetter(){
        Game game = new Game();
        game.setId("1");
        game.setName("Tanks");
        game.setGenre("arcade");
        game.setPlatform("PC");
        game.setReleaseYear(2020);
        game.setPrice(26);
        game.setDeveloper("Mark");

        assertEquals("1", game.getId());
        assertEquals("Tanks", game.getName());
        assertEquals("arcade", game.getGenre());
        assertEquals("PC", game.getPlatform());
        assertEquals("Mark", game.getDeveloper());
        assertEquals(20202, game.getReleaseYear());
        assertEquals(26, game.getPrice());

    }



    @Test
    public void testEquals(){
        Game game1 = new Game("1",2, "WORLD OF TANKS","arcade","PC",2021,"Krid");
        Game game2 = new Game("1",2, "WORLD OF TANKS","arcade","PC",2021,"Krid");
        assertEquals(game1, game2);
        assertEquals(game1.hashCode(), game2.hashCode());
    }
}
