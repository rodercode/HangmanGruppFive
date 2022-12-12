package Game;

import javafx.scene.LightBase;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Database {

    private static final Database instance = new Database();

   private HashMap<Integer, String> listOfWords;


    public Database() {
        listOfWords = new HashMap<>();
    }

    public void addWord(int player, String word){
        listOfWords.put(player,word);
    }

    public static Database getInstance(){
        return instance;
    }


    public HashMap<Integer, String> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(HashMap<Integer, String> listOfWords) {
        this.listOfWords = listOfWords;
    }
}
