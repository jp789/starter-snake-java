package com.battlesnake.starter;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;

public class Coordinate {
  private int xcoord, ycoord;
  /*It might be useful to have a coordinate class to make computation easier 
  e.g. getting euclidean distance between two Coordinate objects would be easier than 
  getting euclidean distance between two maps with type Map<String, Integer> 
  
  Then we could use it for both food, and body!*/

  @JsonGetter("x")
  public int getXcoord() {
    return this.xcoord;
  }

  @JsonSetter("x")
  public void setXcoord(int xcoord) {
    this.xcoord = xcoord;
  }

  @JsonGetter("y")
  public int getYcoord() {
    return this.ycoord;
  }

  @JsonSetter("y")
  public void setYcoord(int ycoord) {
    this.ycoord = ycoord;
  }

  // need default constructor to allow Jackson lib to deserialize objects
  public Coordinate(){
    super();
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