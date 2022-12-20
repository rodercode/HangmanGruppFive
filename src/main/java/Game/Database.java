package Game;

import javafx.scene.LightBase;
import javafx.scene.chart.PieChart;

import java.util.*;

public class Database {

    private static final Database instance = new Database();
   private HashMap<Integer, String> listOfWords;
   private HashMap<Integer,Integer> playerScores;
   //private List<Integer> players;
   private int amountOfPlayers;
   private int currentPlayer;
   private int enemyPlayer;

    private boolean isItGameOver;
    private boolean  didIScore;
    private Database() {
        currentPlayer = 1;
        enemyPlayer = 2;
        listOfWords = new HashMap<>();
        playerScores = new HashMap<>();
        listOfWords.put(1, "KAFFE");
        listOfWords.put(2, "TE");
        isItGameOver = false;
        didIScore = false;

    }

    public void createPlayer(int howManyPlayers){
        amountOfPlayers=howManyPlayers;
        for (int player = 0; player < howManyPlayers; player++) {
            playerScores.put((player+1),0);
        }
    }

    public void switchPlayer(){
       if (currentPlayer == 2){
           currentPlayer--;
           enemyPlayer++;
       }else {
           currentPlayer++;
           enemyPlayer--;
       }
    }
    public void addScore(int player){
        int score = getPlayerScores().get(player) + 5;
        playerScores.put(player,score);
    }


    public HashMap<Integer, Integer> getPlayerScores() {
        return playerScores;
    }

    public void addWord(int player, String word){
        listOfWords.put(player,word);
    }

    public static Database getInstance(){
        return instance;
    }


    public boolean isItGameOver() {
        return isItGameOver;
    }

    public void setItGameOver(boolean itGameOver) {
        isItGameOver = itGameOver;
    }

    public boolean isDidIScore() {
        return didIScore;
    }

    public void setDidIScore(boolean didIScore) {
        this.didIScore = didIScore;
    }

    public void setListOfWords(HashMap<Integer, String> listOfWords) {
        this.listOfWords = listOfWords;
    }

    public HashMap<Integer, String> getListOfWords() {
        return listOfWords;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getEnemyPlayer() {
        return enemyPlayer;
    }

    public void setEnemyPlayer(int enemyPlayer) {
        this.enemyPlayer = enemyPlayer;
    }

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }
}
