package Game;

import javafx.scene.LightBase;
import javafx.scene.chart.PieChart;

import java.util.*;

public class Database {

    private static final Database instance = new Database();
   private HashMap<Integer, String> listOfWords;
   private HashMap<Integer,Integer> playerScores;
   private List<Integer> players;
   private int score;

    private boolean isItGameOver;
    private boolean  didIScore;
    private Database() {
        listOfWords = new HashMap<>();
        playerScores = new HashMap<>();
        players = Arrays.asList(1,2);
        listOfWords.put(1,"KAFFE");
        listOfWords.put(2,"TE");
        score = 5;
        isItGameOver = false;
        didIScore = false;
    }

    public void createPlayer(int howManyPlayers){
        for (int player = 0; player < howManyPlayers; player++) {
            playerScores.put((player+1),0);
        }
    }
    public void addScore(int player){
        playerScores.put(player,score);
    }

    public int getScore() {
        return score;
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

    public List<Integer> getPlayers() {
        return players;
    }

    public void setPlayers(List<Integer> players) {
        this.players = players;
    }

    public HashMap<Integer, String> getListOfWords() {
        return listOfWords;
    }
}
