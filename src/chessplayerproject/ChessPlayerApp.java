package chessplayerproject;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author rebecca pasto
 */
public class ChessPlayerApp {
    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();
        
        // File Input
        List<ChessPlayer> players = FileIOChessPlayer.readPlayerFromFile(
                "/finalprojectchessplayer/InputChessPlayer.txt");
        
        // Title section
        output.append("=================================================\n");
        output.append("              CHESS PLAYER REPORT\n");
        output.append("=================================================\n\n");

        // Polymorphism: superclass reference to reference objects of a subclass
        Player p = players.get(0);
        
        output.append("SECTION 1: Top Player\n");
        output.append("-------------------------------------------------\n");
        output.append("Top Player in Chess Today: ")
            .append(p.getFirstName()).append(" ").append(p.getLastName()).append("\n\n");
        
        output.append("\n");

        // Sort by Rating using Comparable
        Collections.sort(players);
        output.append("SECTION 2: Players Sorted by Rating (Ascending)\n");
        output.append("-------------------------------------------------\n");
        output.append(String.format("%-21s %-10s\n", "Name", "Rating"));
        output.append("-------------------------------------------------\n");
        
        for (ChessPlayer one : players) {
            output.append(String.format("%-21s %-10d\n",
            one.getFirstName() + " " + one.getLastName(),
            one.getRating()));
        }
        output.append("\n");

        // Array based data structure can be selected from Stack
        MyStack stack = new MyStack();
        for (ChessPlayer px : players) stack.push(px);
            output.append("SECTION 3: Reversing List with Stack \n");
            output.append("-------------------------------------------------\n");
            output.append(String.format("%-21s %-10s\n", "Name", "Updated Rating"));
            output.append("-------------------------------------------------\n");
        
           
        if(!stack.isEmpty()){
            ChessPlayer top = stack.peek();
            top.getUpdatedRating(33, 9, 5);
        }
        while (!stack.isEmpty()) {
            ChessPlayer pz = stack.pop();
            output.append(String.format(
                "%-10s %-10s %-10d\n",
                pz.getFirstName(),
                pz.getLastName(),
                pz.getRating()));
            }
            output.append("\n");

        // Sorting Algorithms - Insertion Sort by Age
        InsertionSort sort = new InsertionSort();
        sort.sortByAge(players);

        output.append("SECTION 4: Insertion Sort by Age (DESCENDING) \n");
        output.append("-------------------------------------------------\n");
        output.append(String.format("%-21s %-10s\n", "Name", "Age"));
        output.append("-------------------------------------------------\n");
        
        for (ChessPlayer ps : players) {
            output.append(String.format(
                "%-10s %-10s %-10s\n",
                ps.getFirstName(),
                ps.getLastName(),
                ps.getAge(ps.getBirthYear())));
        }
        
        output.append("\n");

        // Sorting Algorithms - Merge sort by chess title and number of games
        MergeSort ms = new MergeSort();
        ms.sortByTitleAndGames(players);

        output.append("SECTION 4: Merge Sort for Title & Number of Games \n");
        output.append("-------------------------------------------------\n");
        output.append(String.format("%-20s %-10s %-10s\n", "Name", "Title", "Games"));
        output.append("-------------------------------------------------\n");
        
        for (ChessPlayer cp : players) {
            output.append(String.format(
            "%-10s %-10s %-10s %-10d\n",
            cp.getFirstName(),
            cp.getLastName(),
            cp.getChessTitle(),
            cp.getTotalGames()));
        }
        output.append("\n");

        output.append("SECTION 6: Total Number Players \n");
        output.append("-------------------------------------------------\n");
        output.append(String.format("%-20s\n", "Name"));
        output.append("-------------------------------------------------\n");
        for (ChessPlayer cp : players) {
            output.append(String.format(
            "%-10s %-10s\n",
            cp.getFirstName(),
            cp.getLastName()));
        }
        output.append("\n");
        output.append("Top Player in Chess Today: ")
            .append(ChessPlayer.getPlayerCount()).append("\n");
        output.append("\n");
        
        output.append("SECTION 7: Linear Search for Player Name \n");
        output.append("-------------------------------------------------\n");
        output.append(String.format("%-23s %-10s\n", "Name", "Match Found"));
        output.append("-------------------------------------------------\n");
        String result = ChessPlayer.searchByName(players, "Hikaru", "Nakamura");
        String found = (result != null) ? "Yes" : "No";
        output.append(String.format(
                "%-23s %-10s\n",
                ("Hikaru Nakamura"),
                found));

        // Write output to File
        FileIOChessPlayer.writeStringToFile("src/finalprojectchessplayer/OutputChessPlayers.txt", output.toString());
    }
}
