package chessplayerproject;

import java.util.Arrays;
import java.util.List;

/**
 * @author rebecca pasto
 * Sorting Algorithms - Merge sort by chess title and number of games
 */
public class MergeSort {
    // Recursive Method - sortByTitleAndGames()
    public void sortByTitleAndGames(List<ChessPlayer> players){
        if(players.size() < 2){
            return;
        }
        int mid = players.size() / 2;
        
        // Splitting list into left and right
        ChessPlayer[] left = new ChessPlayer[mid];
        ChessPlayer[] right = new ChessPlayer[players.size() - mid];
        
        for(int i = 0; i < mid; i++){
            left[i] = players.get(i);
        }
        for (int i = mid; i < players.size(); i++){
            right[i - mid] = players.get(i);
        }
        sortByTitleAndGames(Arrays.asList(left));
        sortByTitleAndGames(Arrays.asList(right));
        
        mergeSort(players, left, right);
    }
    
    public void mergeSort(List<ChessPlayer> players, ChessPlayer[] left, ChessPlayer[] right){
        int i =0, j = 0, k = 0;
        
        while(i < left.length && j < right.length){
            if(left[i].getChessTitle().compareTo(right[j].getChessTitle()) < 0 || (left[i].getChessTitle().equals(right[j].getChessTitle()) && left[i].getTotalGames() <= right[j].getTotalGames())){
                players.set(k++, left[i++]);
            } else {
                players.set(k++, right[j++]);
            }
        }
        while(i < left.length){
            players.set(k++, left[i++]);
        }
        while(j < right.length){
            players.set(k++, right[j++]);
        }
    }
    public void printMergeSort(List<ChessPlayer> players){
        for(ChessPlayer p : players){
            System.out.println(p.getFirstName() + " " + p.getLastName() + " | Chess title: " + p.getChessTitle() + " | Age: " + p.getChessTitle());
        }
    }
}
