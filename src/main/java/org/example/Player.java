package org.example;

public class Player {
    private String name;
    private int score;


    /**
     * Default Player Constructor
     * **/
    Player() {
        name = "Maaz";
        score = 0;
    }

    /**
     * Constructor that takes in all member variables as parameters
      **/

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     *  Deep copy contructor
     *  **/
    Player(Player other) {
        this.name = other.name;
        this.score = other.score;
    }

    /** Getter methods for name and score **/
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

    /** Setter methods for name and score **/
    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** Clones a deep copy of the current player instance. **/
   public Player createClone() {
        return new Player(this.name, this.score);
    }


    /** The equals method returns a value based on the values. If the names are equal, then it returns true. **/
    @Override
    public boolean equals(Object o) {
        Player p = (Player) o;
        if(this.name.equals(p.name)) {
            return true;
        }
        return false;
    }


}
