package gameslib;

import java.util.*;

public class GamesLibrary{

  Set<Platform> platforms;
  Set<Game> games;

  /**
   * Default constructor.
   */
  public GamesLibrary(){
    this.platforms = new HashSet<>();
    this.games = new HashSet<>();
  }

  /**
   * Adds a new platform to the game library.
   *
   * @param platform Platform (must not be null)
   * @throws GamesLibraryException if platform is already in games library.
   */
  public void addPlatform(Platform platform){

    if(platform == null){
      throw new IllegalArgumentException();
    }
    if(platforms.contains(platform)){
      throw new GamesLibraryException("");
    }
    platforms.add(platform);
  }

  /**
   * Removes the given platform and all games on this platform from the library.
   *
   * @param platform Platform to remove (along with all games), must be in
   * library and must not be null
   * @throws GamesLibraryException if platform is not in games library
   */
  public void removePlatform(Platform platform){
    if(platform == null){
      throw new IllegalArgumentException();
    }
    if(!platforms.contains(platform)){
      throw new GamesLibraryException("");
    }
    platforms.remove(platform);

  }

  /**
   * Adds a new game to the games library.
   *
   * @param game game to add (must not be null)
   *
   * @throws GamesLibraryException if game is already in library or platform of
   * game is not in game library
   */
  public void addGame(Game game){

   if(game == null){
     throw new IllegalArgumentException();
   }

   if(games.contains(game)){
     throw new GamesLibraryException("");
   }
    games.add(game);
  }

  /**
   * Removes a game from the game library.
   *
   * @param game game to remove, must not be null
   * @throws GamesLibraryException if game is not in library
   */
  public void removeGame(Game game){
    games.remove(game);
  }

  /**
   * Returns the sorted set of games.
   * The set must be ordered according to Game.compareTo
   * @return set of games as a read-only set
   */
  public Set<Game> getGamesReadOnly(){
    return Collections.unmodifiableSet(games);
  }

  /**
   * Returns the sorted set of platforms.
   * The set must be ordered according to Platform.compareTo
   * @return set of platforms as a read-only set
   */
  public Set<Platform> getPlatformsReadOnly(){
    return  Collections.unmodifiableSet(platforms);
  }

  /**
   * Returns the game with the highest metacritic score.
   *
   * @return game with highest metacritic score (or null if games library is
   * empty)
   */
  public Game getBestGame(){
    Game bestGame = null;
    int maxScore = 0;

    for(Game game : games){
      if(game.getMetacriticScore() > maxScore){
        bestGame = game;
        maxScore = game.getMetacriticScore();
      }
    }

    return bestGame;
  }

  /**
   * Returns a map the maps a genre to the number of games of the genre in the
   * games library.
   *
   * @return map from genre to number of games of the genre
   */
  public Map<Genre, Integer> getGenreCount(){
    int counter = 0;
    Map<Genre, Integer> map = new TreeMap<>();
    for(Genre genre : Genre.values()){
      for(Game game : games){
        if(game.getGenre() == genre){
          counter ++;
        }
      }
      map.put(genre, counter);
      counter = 0;
    }

    return map;
  }

  /**
   * Returns a map from the platforms to the set of games on that platform.
   */
  public Map<Platform, Set<Game>> getGamesForPlatform(){
    Map<Platform, Set<Game>> map = new HashMap<>();
    Set<Game> gameSet = new TreeSet<>();
    for(Platform platform : platforms) {
      for (Game game : games) {
        if (game.getPlatform() == platform) {
          gameSet.add(game);
        }
      }
      map.put(platform,gameSet);
      gameSet.clear();
    }
    return map;
  }

  /**
   * Returns a map from all platforms to their average metacritic scores.
   */
  public Map<Platform, Double> getAverageScoreForPlatform(){
    var gamemaps = getGamesForPlatform();
    int score = 0;
    var scorema

    for(Map.Entry<Platform,Set<Game>> entry : gamemaps.entrySet()){


    }



    return null;
  }

  /** 
   * Returns the platform with the highest averaga metacritic score.
   */
  public Platform getBestPlatform(){
    // TODO
    return null;
  }


  /**
   * Returns a list with all games ordered from highest to lowest metacritic
   * score.
   */
  public List<Game> sortGamesByMetacriticScore(){

    List<Game> sortetgames = new ArrayList<>(games);

    Comparator<Game> comp = new Comparator<>() {
      @Override
      public int compare(Game game, Game t1) {
        return -Double.compare(game.getMetacriticScore(),t1.getMetacriticScore());
      }

      @Override
      public boolean equals(Object o) {
        return false;
      }
    };
    sortetgames.sort(comp);
    return sortetgames;
  }

  /**
   * Returns a list with all games ordered, first, by release year (ascending)
   * and, second, by name.
   */
  public List<Game> sortGamesByReleaseYear(){
    // TODO
    return null;
  }


}
