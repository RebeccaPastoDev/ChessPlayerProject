package chessplayerproject;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIOChessPlayer {
    // To Read in Input File
    public static List<ChessPlayer> readPlayerFromFile(String filename){ 
        List<ChessPlayer> players = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(FileIOChessPlayer.class.getResourceAsStream(filename)))) 
        {
            if (br == null) {
                System.err.println("File not found in package: " + filename);
                return players;
            }

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
            
            int fieldsPerPlayer = 11;
            for(int i = 0; i + fieldsPerPlayer-1 < lines.size(); i+= fieldsPerPlayer){
                try {
                        String firstName = lines.get(i); 
                        String lastName = lines.get(i + 1); 
                        String country = lines.get(i + 2); 
                        String gender = lines.get(i + 3); 
                        int birthYear = Integer.parseInt(lines.get(i + 4));
                        String chessTitle = lines.get(i + 5);
                        int totalGames = Integer.parseInt(lines.get(i + 6)); 
                        boolean isGrandmaster = Boolean.parseBoolean(lines.get(i + 7)); 
                        int rating = Integer.parseInt(lines.get(i + 8));
                        String coachFirstName = lines.get(i+9); 
                        String coachLastName = (lines.get(i+10));
                        
                        Coach coach = new Coach(coachFirstName, coachLastName);
                        ChessPlayer p = new ChessPlayer(firstName, lastName, country, gender, birthYear, chessTitle, totalGames, isGrandmaster, rating, coach);
                        players.add(p);
                        
                // Java API Exception class NumberFormatException       
                } catch (NumberFormatException nfe) {
                    Logger.getLogger(FileIOChessPlayer.class.getName()).log(Level.WARNING,
                        "Skipping a player record due to number parse error at index " + i, nfe);
                }
            }
            
            // Java API Exception class IOEXception
        } catch (IOException ex) {
            Logger.getLogger(FileIOChessPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }
    
    // To Write into Output File
    // Method Overloading - writePlayersToFile
    public static void writePlayersToFile(String filename, List<ChessPlayer> players ){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))){
            for(ChessPlayer p : players){
                pw.println(p.getFirstName() + "," + p.getLastName() + "," + p.getCountryOfOrigin() + "," +
                           p.getGender() + "," + p.getBirthYear() + "," + p.getChessTitle() + "," +
                           p.getTotalGames() + "," + p.getIsGrandmaster() + "," + p.getRating() + "," +
                          (p.getCoach() != null ? p.getCoach().getCoachFirstName() : "NoCoach") + "," +
                          (p.getCoach() != null ? p.getCoach().getCoachLastName() : "NoCoach"));
            }
            
            System.out.println("Players successfully written to " + filename);
            
        // Java API Exception class IOEXception
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    // Method Overloading - writePlayersToFile
    public static void writeStringToFile(String filename, String content) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.print(content); 
            System.out.println("Output written to " + filename);
            
        // Java API Exception class IOEXception
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}