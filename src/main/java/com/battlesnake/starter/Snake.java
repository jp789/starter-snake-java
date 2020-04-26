package com.battlesnake.starter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Map;

public class Snake {
  private String id, name, shout;
  private int health;
  private List<Coordinate> body;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShout() {
    return this.shout;
  }

  public void setShout(String shout) {
    this.shout = shout;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public List<Coordinate> getBody() {
    return this.body;
  }

  public void setBody(List<Coordinate> body) {
    this.body = body;
  }

  public Snake(String snakeID, String name, String shout, int health, List<Coordinate> body){

    this.id= snakeID;
    this.name = name;
    this.shout = shout;
    this.health = health;
    
    // will initialize the body when i understand how to convert Jsonnode list of dicts to java obj...
    this.body = body;

    /* Think the body is initially a list of 3 coordinate pairs: the first pair is the head, 
    the 2nd pair is the torso, the 3rd pair is the tail. Presumably as the snake eats the list gets bigger
    i.e. the body grows
    e.g starting off
    "body" : [ {
      "x" : 5,
      "y" : 3
    }, {
      "x" : 5,
      "y" : 3
    }, {
      "x" : 5,
      "y" : 3
    } ]
    
    After moving left
    "body" : [ {
        "x" : 4,
        "y" : 3
      }, {
        "x" : 5,
        "y" : 3
      }, {
        "x" : 5,
        "y" : 3
      } ]*/
  }

  // constructor can just parse the JsonNode into a java snake object!
  public Snake(JsonNode snake){
    /* 
    Sample snake body:
    {
        "id": "snake-id-string",
        "name": "Sneky Snek",
        "health": 90,
        "body": [
          {
            "x": 1,
            "y": 3
          },
          {
            "x": 1,
            "y": 3
          },
          {
            "x": 1,
            "y": 3
          }
        ],
        "shout": "Hello my name is Sneky Snek"
    }
    */


  }
  public String toString(){
    return "Snake id: " + this.id +
    " Snake health: " + this.health +
    " Snake name: " + this.name +
    " Snake shout: " + this.shout +
    " the body: " + this.body.toString();
  }
  

}