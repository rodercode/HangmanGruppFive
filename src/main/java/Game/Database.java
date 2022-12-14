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
    public Database() {
        listOfWords = new HashMap<>();
        playerScores = new HashMap<>();
        players = Arrays.asList(1,2);
        listOfWords.put(1,"Kaffe");
        listOfWords.put(2,"TE");
        score = 0;
    }
    public void addScore(int player){
        score = score +5;
        playerScores.put(player,score);
    }

    public int getScore() {
        return score;
    }

    public void addWord(int player, String word){
        listOfWords.put(player,word);
    }

    public static Database getInstance(){
        return instance;
    }


   /* public void getListOfWords() {
        for( Map.Entry<Integer, String> entry : listOfWords.entrySet() ){
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }
    } */


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
