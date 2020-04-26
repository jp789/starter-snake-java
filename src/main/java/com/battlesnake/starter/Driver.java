package com.battlesnake.starter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.get;

/**
 * This is a simple Battlesnake server written in Java.
 * 
 * For instructions see
 * https://github.com/BattlesnakeOfficial/starter-snake-java/README.md
 */
public class Driver {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final Handler HANDLER = new Handler();
    private static final Logger LOG = LoggerFactory.getLogger(Driver.class);

    // map of boards the battlesnake will be playing on, i.e. gameid -> board obj
    // for now it'll be 1 key-val pair, i.e. only playing one game at a time
    private static final Map<String, Board> BOARDS =  new HashMap<String, Board>();
  
    /**
     * Main entry point.
     *
     * @param args are ignored.
     */
    public static void main(String[] args) {
        String port = System.getProperty("PORT");
        if (port != null) {
            LOG.info("Found system provided port: {}", port);
        } else {
            port = "8080";
            LOG.info("Using default port: {}", port);     
        }
        port(Integer.parseInt(port));
        get("/", (req, res) -> "Your Battlesnake is alive!");
        post("/start", HANDLER::process, JSON_MAPPER::writeValueAsString);
        post("/ping", HANDLER::process, JSON_MAPPER::writeValueAsString);
        post("/move", HANDLER::process, JSON_MAPPER::writeValueAsString);
        post("/end", HANDLER::process, JSON_MAPPER::writeValueAsString);
    }

    /**
     * Handler class for dealing with the routes set up in the main method.
     */
    public static class Handler {

        /**
         * For the ping request
         */
        private static final Map<String, String> EMPTY = new HashMap<>();

        /**
         * Generic processor that prints out the request and response from the methods.
         *
         * @param req
         * @param res
         * @return
         */
        public Map<String, String> process(Request req, Response res) {
            try {
                JsonNode parsedRequest = JSON_MAPPER.readTree(req.body());
                String uri = req.uri();
                LOG.info("{} called with: {}", uri, req.body());
                Map<String, String> snakeResponse;
                if (uri.equals("/start")) {
                    snakeResponse = start(parsedRequest);
                } else if (uri.equals("/ping")) {
                    snakeResponse = ping();
                } else if (uri.equals("/move")) {
                    snakeResponse = move(parsedRequest);
                } else if (uri.equals("/end")) {
                    snakeResponse = end(parsedRequest);
                } else {
                    throw new IllegalAccessError("Strange call made to the snake: " + uri);
                }
                LOG.info("Responding with: {}", JSON_MAPPER.writeValueAsString(snakeResponse));
                return snakeResponse;
            } catch (Exception e) {
                LOG.warn("Something went wrong!", e);
                return null;
            }
        }

        /**
         * The Battlesnake engine calls this function to make sure your snake is
         * working.
         * 
         * @return an dummy response. The Battlesnake engine will not read this data.
         */
        public Map<String, String> ping() {
            Map<String, String> response = new HashMap<>();
            response.put("message", "pong");
            return response;
        }

        /**
         * This method is called everytime your Battlesnake is entered into a game.
         * 
         * Use this method to decide how your Battlesnake is going to look on the board.
         *
         * @param startRequest a JSON data map containing the information about the game
         *                     that is about to be played.
         * @return a response back to the engine containing the Battlesnake setup
         *         values.
         */
        public Map<String, String> start(JsonNode startRequest) {
            LOG.info("START");
            
            // start initializing board

            Board board = JSON_MAPPER.convertValue(startRequest.at("/board"), Board.class);
            
            String gameID = startRequest.at("/game/id").asText();
            board.setGameID(gameID);

            BOARDS.put(gameID, board);
            
            LOG.info("After parsing the board");
            LOG.info(BOARDS.get(gameID).toString());
            
            Map<String, String> response = new HashMap<>();
            response.put("color", "#8ec298");
            response.put("headType", "bendr");
            response.put("tailType", "round-bum");
            return response;
        }

        /**
         * This method is called on every turn of a game. It's how your snake decides
         * where to move.
         * 
         * Valid moves are "up", "down", "left", or "right".
         *
         * @param moveRequest a map containing the JSON sent to this snake. Use this
         *                    data to decide your next move.
         * @return a response back to the engine containing Battlesnake movement values.
         */
        public Map<String, String> move(JsonNode moveRequest) {
            try {
                LOG.info("Data: {}", JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(moveRequest));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            
            /*  
              - get current game board
              - [update food + snakes?]
              - get legal moves -> 
                  i.e. call a Board func that takes snake parameter and spits out array of legal moves
                and assign to possibleMoves below
            */
            String currGame = moveRequest.at("/game/id").asText();
            Board currBoard = BOARDS.get(currGame);

            String[] possibleMoves = { "up", "down", "left", "right" };

            // Choose a random direction to move in
            int choice = new Random().nextInt(possibleMoves.length);
            String move = possibleMoves[choice];

            LOG.info("MOVE {}", move);

            Map<String, String> response = new HashMap<>();
            response.put("move", move);
            return response;
        }

        /**
         * This method is called when a game your Battlesnake was in ends.
         * 
         * It is purely for informational purposes, you don't have to make any decisions
         * here.
         *
         * @param endRequest a map containing the JSON sent to this snake. Use this data
         *                   to know which game has ended
         * @return responses back to the engine are ignored.
         */
        public Map<String, String> end(JsonNode endRequest) {

            LOG.info("END");
            return EMPTY;
        }
    }

}
