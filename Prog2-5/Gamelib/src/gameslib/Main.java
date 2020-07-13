package gameslib;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GamesLibrary lib = new GamesLibrary();
        Platform plat = new Platform("g","d");
        Platform plat2 = new Platform("fd","ds");
        Game gam = new Game("first",Genre.ACTION,plat,200,15);
        Game game2 = new Game("second",Genre.ACTION,plat,200,12);
        lib.addGame(gam);
        lib.addGame(game2);
        lib.addPlatform(plat);
        lib.addPlatform(plat2);

        System.out.println(lib.getBestGame().getName());
    }
}
