package com.battlesnake.starter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Map;

public class Snake {
  private String snakeID, name, shout;
  private int health;
  private List<Map<String, String>> body;

  public Snake(String snakeID, String name, String shout, int health){ //, List body){

    this.snakeID = snakeID;
    this.name = name;
    this.shout = shout;
    this.health = health;

    // will initialize the body when i understand how to convert Jsonnode list of dicts to java obj...
    // this.body = (List<Map <String, String>>) body;

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
  
}