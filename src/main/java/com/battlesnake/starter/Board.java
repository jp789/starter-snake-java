package com.battlesnake.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
  private String gameID;
  private int height, width;
  private List<Coordinate> food;

  private List<Snake> snakes;

  public Board (JsonNode startRequest){
    // use json sent in startrequest to initialize the board

    /* Will need to chain constructors, so first call has to be
    this(functogetgameidfromreq, ...., functogetlistofsnakesfromreq) 
    Those would have to be static functions to parse start/ json
    Refer to:
    https://stackoverflow.com/questions/285177/how-do-i-call-one-constructor-from-another-in-java/#15348070
    */


    ObjectMapper objectMapper = new ObjectMapper();

    // start initializing board
    String gameID = startRequest.at("/game/id").asText();
    int height = startRequest.at("/board/height").asInt();
    int width = startRequest.at("/board/width").asInt();
    
    List<Coordinate> food = new ArrayList<Coordinate>();
    ArrayNode foodNode = (ArrayNode)startRequest.at("/board/food");

    for(int i = 0; i < foodNode.size(); i++){
      food.add(new Coordinate(foodNode.get(i)));
    }
    
    
  }
  public Board(String gameID, int height, int width, List<Coordinate> food, List<Snake> snakes){
    this.gameID = gameID;
    this.height = height;
    this.width = width;
    this.food = food;
    this.snakes = snakes;
  }

  public Board(String gameID, int height, int width, List<Coordinate> food) {
    this.gameID = gameID;
    this.height = height;
    this.width = width;
    this.food = food;
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