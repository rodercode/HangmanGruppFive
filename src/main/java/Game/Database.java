package Game;

import javafx.scene.LightBase;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final Database instance = new Database();

    private List<String> listOfWords;

    public Database() {
        listOfWords = new ArrayList<>();

    }

    public static Database getInstance(){
        return instance;
    }

    

    public List<String> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(List<String> listOfWords) {
        this.listOfWords = listOfWords;
    }
}
