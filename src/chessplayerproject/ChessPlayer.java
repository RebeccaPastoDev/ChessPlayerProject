package chessplayerproject;
import java.time.Year;
import java.util.List;
/**
 * @author rebecca pasto
 * Subclass
 */
public class ChessPlayer extends Player implements Comparable<ChessPlayer>{
    // Data members
    private String chessTitle;
    private int totalGames;
    private boolean isGrandmaster;
    private int rating;
    
    // Static member - playerCount
    private static int playerCount = 0;
    
    // Aggregation in class
    private Coach coach;

    public ChessPlayer( ){
        super("","","","",0);
        chessTitle = "";
        totalGames = 0;
        isGrandmaster = false;
        rating = 0;
        this.coach = new Coach();
    }
    public ChessPlayer(String firstName, String lastName, String countryOfOrigin, 
            String gender, int birthYear, String chessTitle, int totalGames, boolean isGrandmaster, int rating, Coach coach){
        
        super(firstName, lastName, countryOfOrigin, gender, birthYear);
        this.chessTitle = chessTitle;
        this.totalGames = totalGames;
        this.isGrandmaster = isGrandmaster;
        this.rating = rating;
        this.coach = (coach == null) ? new Coach() : coach;
        playerCount++;
    }
    
    // Accessor Methods for subclass
    public String getChessTitle(){
        return chessTitle;
    }
    public int getTotalGames(){
        return totalGames;
    }
    public boolean getIsGrandmaster(){
        return isGrandmaster;
    }
    public int getRating(){
        return rating;
    }
    
    public Coach getCoach(){
        return this.coach;
    }
    
    // Mutator Methods for subclass
    public void setChessTitle(String chessTitle){
        this.chessTitle = chessTitle;
    }
    public void setTotalGames(int totalGames){
        this.totalGames = totalGames;
    }
    
    public void setIsGrandmaster(boolean isGrandmaster){
        this.isGrandmaster = isGrandmaster;
    }
    
    public void setRating(int rating){
        this.rating = rating;
    }
    public void setCoach(Coach coach){
        this.coach = coach;
    }
    
    // Method for insertion sort
    // Method overriding - getAge()
    @Override
    public int getAge(int birthYear){
        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;
        return age;
    }
    
    // Overriding method - compareTo()
    // Method overriding - getAge()
    @Override
    public int compareTo(ChessPlayer ch){
        return Integer.compare(this.rating, ch.rating);
    }
    
    // Static method - getPlayerCount()
    public static int getPlayerCount(){
        return playerCount;
    }
    
    // Method Overloading - getUpdatedRating()
    public void getUpdatedRating(int points){
        this.rating += points;
    }
    
    // Method Overloading - getUpdatedRating()
    public void getUpdatedRating(int wins, int losses, int draws){
        int score = (wins * 10) + (draws* 5) - (losses *2);
        this.rating += score;
    }
    
    // Searching Algorithm - Linear Search
    public static String searchByName(List<ChessPlayer> players, String firstName, String lastName){
        for(ChessPlayer p : players){
            if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)){
                String name = firstName + " " + lastName;
                return name;
            }
        }
        return null;
    }
    
    // Method overriding - toString()
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", " + getCountryOfOrigin() +
               ", " + getGender() + ", " + getBirthYear() +
               ", " + chessTitle + ", Games: " + totalGames +
               ", GM: " + isGrandmaster + ", Rating: " + rating +
               ", Coach: " + coach;
    }
}


