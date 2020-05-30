package com.battlesnake.starter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Optional;

public class Board {
  @JsonIgnore
  private String gameID;

  private int height, width;
  private List<Coordinate> food;
  private List<Snake> snakes;

  public Board(){
    super();
  }

  // technically isn't used by ObjectMapper, but i'd like to keep it in case I wanna make my own board objects
  public Board(String gameID, int height, int width, List<Coordinate> food, List<Snake> snakes){
    this.gameID = gameID;
    this.height = height;
    this.width = width;
    this.food = food;
    this.snakes = snakes;
  }

  public String getGameID() {
    return this.gameID;
  }
 
  public void setGameID(String gameID) {
    this.gameID = gameID;
  }

  public int getHeight() {
    return this.height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return this.width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public List<Coordinate> getFood() {
    return this.food;
  }

  public void setFood(List<Coordinate> food) {
    this.food = food;
  }

  public List<Snake> getSnakes() {
    return this.snakes;
  }

  public void setSnakes(List<Snake> snakes) {
    this.snakes = snakes;
  }

  // get legal moves for the snake
  public String[] getLegalMoves(String snakeID){

    // using streams so post
    // https://stackoverflow.com/questions/33992479/java-8-stream-api-to-find-unique-object-matching-a-property-value/#33993343
    // get current snake
    Snake currSnake;
    Optional<Snake> tmp = this.snakes.stream().filter((snake) -> { 
      return snake.getId().equals(snakeID);
    }).findAny();

    if(tmp.isPresent()){
      currSnake = tmp.get();
      System.out.println("Found your snake!");
    }
    else{
      System.out.println("No snake on board with: " + snakeID);
    }

    
    // always go up - just testing i actually grab the right snake above^
    String[] temp = { "up"};
    return temp;
  }

  public String toString() {

    if(this.snakes != null){
      return "GameID: " + this.gameID + 
    " board height " + this.height + 
    " board width: " + this.width +
    " food pellets: " + this.food.toString() + 
    " snakes on the board: " + this.snakes.toString();
    }

    else {
      return "GameID: " + this.gameID + 
    " board height " + this.height + 
    " board width: " + this.width +
    " food pellets: " + this.food.toString();
    }

  }

}