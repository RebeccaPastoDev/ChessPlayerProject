package chessplayerproject;
/**
 * @author rebecca pasto
 * Abstract Superclass
 */
public abstract class Player implements Person {
    // Data members
    private String firstName;
    private String lastName;
    private String countryOfOrigin;   
    private String gender;
    final int birthYear;
    
    public Player(){
        firstName = "";
        lastName = "";
        countryOfOrigin = "";  
        gender = "";
        birthYear = 0;
    }
    public Player(String firstName, String lastName, String countryOfOrigin, String gender, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryOfOrigin = countryOfOrigin;
        this.gender = gender;
        this.birthYear = birthYear;
    }
    
    // Accessor Methods for abstract superclass
    // Method overriding - getFirstName()
    @Override
    public String getFirstName(){
        return firstName;
    }
    // Method overriding - getLastName()
    @Override
    public String getLastName(){
        return lastName;
    }
    // Method overriding - getCountryOfOrigin()
    @Override
    public String getCountryOfOrigin(){
        return countryOfOrigin;
    }
    // Method overriding - getBirthYear()
    @Override
    public int getBirthYear(){
        return birthYear;
    }
    // Method overriding - getGender()
    @Override
    public String getGender(){
        return gender;
    }
    // Mutator methods for abstract superclass
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setCountryOfOrigin(String countryOfOrigin){
        this.countryOfOrigin = countryOfOrigin;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    // Abstract method
    public abstract int getAge(int birthYear);
}

