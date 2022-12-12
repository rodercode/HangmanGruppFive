package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer>listOfPlayers;
    public Player() {
        listOfPlayers = new ArrayList<>();
    }


    public void addPlayer(int player){
        listOfPlayers.add(player);
    }
}
