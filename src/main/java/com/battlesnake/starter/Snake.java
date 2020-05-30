package com.battlesnake.starter;


import java.util.List;


public class Snake {
  private String id, name, shout;
  private int health;
  private List<Coordinate> body;
  private Coordinate head;
  private int length;

  public int getLength() {
    return this.length;
  }

  public void setLength(int length) {
    this.length = length;
  }


  public Coordinate getHead() {
    return this.head;
  }

  public void setHead(Coordinate head) {
    this.head = head;
  }

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

  public Snake(){
    super();
  }

  public Snake(String snakeID, String name, String shout, int health, List<Coordinate> body, Coordinate head, int length){

    this.id= snakeID;
    this.name = name;
    this.shout = shout;
    this.health = health;
    this.body = body;
    this.head = head;
    this.length

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

  public String toString(){
    return "Snake id: " + this.id +
    " Snake health: " + this.health +
    " Snake name: " + this.name +
    " Snake shout: " + this.shout +
    " the body: " + this.body.toString(); // not including head attr. because it's the first element of body
  }
  

}