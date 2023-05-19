package com.zybooks.dsaj.fundamental;

/**
 * A representation of an entry on a scoreboard.
 */
public class GameEntry {
    private String name;        // name of the person earning this score
    private int score;          // the score value

    /**
     * Constructs a game entry with given parameters.
     * @param n   the user's name
     * @param s   the user's score
     */
    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }
    
    /** 
     * Returns the name field.
     * @return the name of the user
     */
    public String getName() { return name; }
    
    /**
     * Returns the score field.
     * @return the user's score
     */
    public int getScore() { return score; }
    
    /**
     * Returns a string representation of this entry.
     * @return a string representation of the entry
     */
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}
