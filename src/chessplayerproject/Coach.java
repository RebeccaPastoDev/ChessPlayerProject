package chessplayerproject;
/**
 * @author rebecca pasto
 * Aggregation class
 */
public class Coach {
    String firstName;
    String lastName;
    
    public Coach(){
        firstName = "";
        lastName = "";
    }
    public Coach(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Accessor Methods for subclass
    public String getCoachFirstName(){
        return this.firstName;
    }
    public String getCoachLastName(){
        return this.lastName;
    }
    
    // Mutator Methods for subclass
    public void setCoachFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setCoachLastName(String lastName){
        this.lastName = lastName;
    }
    
    // Method overriding - toString()
    @Override
    public String toString(){
        return firstName + " " + lastName;
    }
}

