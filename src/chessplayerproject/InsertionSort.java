package chessplayerproject;
import java.util.List;

/**
 * @author rebecca pasto
 * Sorting Algorithms - Insertion Sort by Age
 */
public class InsertionSort {
    public void sortByAge(List<ChessPlayer> players){
        for (int i = 1; i < players.size(); i++){
            ChessPlayer key = players.get(i);
            int j = i - 1;
            
            while(j >= 0 && players.get(j).getAge(players.get(j).getBirthYear()) < key.getAge(key.getBirthYear())){
                players.set(j + 1, players.get(j));
                j--;
            }
            players.set(j + 1, key);
        }
    }
}
