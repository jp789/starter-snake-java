package com.battlesnake.starter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

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
    String[] temp = { "up", "down", "left", "right" };
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