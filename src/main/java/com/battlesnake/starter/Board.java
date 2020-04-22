package com.battlesnake.starter;


import java.util.List;
import java.util.Map;

public class Board {
  /* The only identifying characteristic of a game is its gameid
  so it seemed like a waste to make a class for Game itself,
  made more sense just to toss it in with Board */
  private String gameID;
  private int height, width;
  private List<Map<String, Integer>> food;
  // food, snakes instance variables tbd

  public Board(String gameID, int height, int width, List<Map<String, Integer>> food){
    this.gameID = gameID;
    this.height = height;
    this.width = width;
    this.food = food;
  }

  public String test(){
    return("This is the board contsructor");
  }

  public String[] getLegalMoves(){
    String[] temp = { "up", "down", "left", "right" };
    return temp;
  }
  public String toString() {
    return "GameID: " + this.gameID + 
    " board height " + this.height + 
    " board width: " + this.width +
    " food pellets: " + this.food.toString();

  }

}