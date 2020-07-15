package gameslib;

import java.util.Objects;

public class Game implements Comparable<Game> {
    private final String name;
    private final Genre gerne;
    private final Platform platform;
    private final int releaseYear;
    private final int metacriticScore;

    public Game(String name, Genre gerne, Platform platform, int releaseYear, int metacriticScore) {
        this.name = name;
        this.gerne = gerne;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.metacriticScore = metacriticScore;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return gerne;
    }

    public Platform getPlatform() {
        return platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getMetacriticScore() {
        return metacriticScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return releaseYear == game.releaseYear &&
                metacriticScore == game.metacriticScore &&
                Objects.equals(name, game.name) &&
                gerne == game.gerne &&
                Objects.equals(platform, game.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gerne, platform, releaseYear, metacriticScore);
    }


    @Override
    public int compareTo(Game game) {

        if(game == null)
            throw new IllegalArgumentException();
        int result = name.compareTo(game.name);

        if (result == 0)
            result = gerne.compareTo(game.gerne);

        if (result == 0)
            result = platform.compareTo(game.platform);

        if (result == 0)
            result = this.releaseYear - game.releaseYear;

        if (result == 0)
            result = Integer.compare(metacriticScore, game.metacriticScore);

        return result;
    }

    }


