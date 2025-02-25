package gameslib;

import java.util.*;

public class GamesLibrary{

  /**
   * Default constructor.
   */
  public GamesLibrary(){
  }

  /**
   * Adds a new platform to the game library.
   *
   * @param platform Platform (must not be null)
   * @throws GamesLibraryException if platform is already in games library.
   */
  public void addPlatform(Platform platform){
    // TODO
  }

  /**
   * Removes the given platform and all games on this platform from the library.
   *
   * @param platform Platform to remove (along with all games), must be in
   * library and must not be null
   * @throws GamesLibraryException if platform is not in games library
   */
  public void removePlatform(Platform platform){
    // TODO
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
    // TODO
  }

  /**
   * Removes a game from the game library.
   *
   * @param game game to remove, must not be null
   * @throws GamesLibraryException if game is not in library
   */
  public void removeGame(Game game){
    // TODO
  }

  /**
   * Returns the sorted set of games.
   * The set must be ordered according to Game.compareTo
   * @return set of games as a read-only set
   */
  public Set<Game> getGamesReadOnly(){
    // TODO
    return null;
  }

  /**
   * Returns the sorted set of platforms.
   * The set must be ordered according to Platform.compareTo
   * @return set of platforms as a read-only set
   */
  public Set<Platform> getPlatformsReadOnly(){
    // TOOD
    return null;
  }

  /**
   * Returns the game with the highest metacritic score.
   *
   * @return game with highest metacritic score (or null if games library is
   * empty)
   */
  public Game getBestGame(){
    // TODO
    return null;
  }

  /**
   * Returns a map the maps a genre to the number of games of the genre in the
   * games library.
   *
   * @return map from genre to number of games of the genre
   */
  public Map<Genre, Integer> getGenreCount(){
    // TODO
    return null;
  }

  /**
   * Returns a map from the platforms to the set of games on that platform.
   */
  public Map<Platform, Set<Game>> getGamesForPlatform(){
    // TODO

    return null;
  }

  /**
   * Returns a map from all platforms to their average metacritic scores.
   */
  public Map<Platform, Double> getAverageScoreForPlatform(){
    // TODO
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
    // TODO
    return null;
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
