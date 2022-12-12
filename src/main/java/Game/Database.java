package Game;

import javafx.scene.LightBase;
import javafx.scene.chart.PieChart;

import java.util.*;

public class Database {

    private static final Database instance = new Database();

   private HashMap<Integer, String> listOfWords;

   private List<Integer> players;


    public Database() {
        listOfWords = new HashMap<>();
        players = Arrays.asList(1,2);
    }

    public void addWord(int player, String word){
        listOfWords.put(player,word);
    }

    public static Database getInstance(){
        return instance;
    }


    public void getListOfWords() {
        for( Map.Entry<Integer, String> entry : listOfWords.entrySet() ){
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }
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
}
