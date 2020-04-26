package com.battlesnake.starter;

import com.fasterxml.jackson.databind.JsonNode;

public class Coordinate {
  private int xcoord, ycoord;
  /*It might be useful to have a coordinate class to make computation easier 
  e.g. getting euclidean distance between two Coordinate objects would be easier than 
  getting euclidean distance between two maps with type Map<String, Integer> 
  
  Then we could use it for both food, and body!*/

  public int getXcoord() {
    return this.xcoord;
  }

  public void setXcoord(int xcoord) {
    this.xcoord = xcoord;
  }

  public int getYcoord() {
    return this.ycoord;
  }

  public void setYcoord(int ycoord) {
    this.ycoord = ycoord;
  }

  public Coordinate(int xcoord, int ycoord) {
    this.xcoord = xcoord;
    this.ycoord = ycoord;
  }

  public Coordinate (JsonNode coord){
    /*  
    coord will be a JsonNode with {x: someint, y:someint}
    e.g.
    {
      "x" : 1,
      "y" : 2
    }
    */
    this.xcoord = coord.get("x").asInt();
    this.ycoord = coord.get("y").asInt();
  }

  @Override
  public String toString() {
    return "{" +
      " xcoord='" + getXcoord() + "'" +
      ", ycoord='" + getYcoord() + "'" +
      "}";
  }

  
}