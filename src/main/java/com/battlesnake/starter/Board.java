package com.battlesnake.starter;

public class Board {
  /* The only identifying characteristic of a game is its gameid
  so it seemed like a waste to make a class for Game itself,
  made more sense just to toss it in with Board */
  private String gameID;
  private int height, width;
  // food, snakes instance variables tbd

  public Board(String gameID, int height, int width){
    this.gameID = gameID;
    this.height = height;
    this.width = width;
  }

  public String test(){
    return("This is the board contsructor");
  }

  public String toString() {
    return "GameID: " + this.gameID + 
    " board height " + this.height + 
    " board width: " + this.width;

  }

}