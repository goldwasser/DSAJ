package com.zybooks.dsaj.fundamental;

/** Class for storing high scores in an array in nondecreasing order. */
public class Scoreboard {
    private GameEntry[] board;                    // array of game entries (names & scores)
    private int numEntries = 0;                   // number of actual entries

    /** Constructs an empty scoreboard with the given capacity for storing entries. */
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    /** Attempt to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        // is the new entry e really a high score?
        if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
            if (numEntries < board.length)        // no score drops from the board
                numEntries++;                     // so overall number increases
            // shift any lower scores rightward to make room for the new entry
            int j = numEntries-1;                 // index where last entry should be
            while (j > 0 && board[j-1].getScore() < newScore) {
                board[j] = board[j-1];            // shift entry from j-1 to j
                j--;                              // and decrement j
            }
            board[j] = e;                         // when done, add new entry
        }
    }

    /** Remove and return the high score at index i. */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        GameEntry temp = board[i];                // save the object to be removed
        for (int j=i; j < numEntries-1; j++)      // count up from i (not down)
            board[j] = board[j+1];                // move one cell to the left
        board[numEntries-1] = null;               // null out the old last score
        numEntries--;
        return temp;                              // return the removed object
    }

    /** Returns a string representation of the high scores list. */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int j=0; j < numEntries; j++) {
            if (j > 0)
                sb.append(", ");                  // separate entries by commas
            sb.append(board[j]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // The main method
        Scoreboard highscores = new Scoreboard(5);
        String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
        int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

        for (int i=0; i < names.length; i++) {
            GameEntry gE = new GameEntry(names[i], scores[i]);
            System.out.println("Adding " + gE);
            highscores.add(gE);
            System.out.println(" Scoreboard: " + highscores);
        }
        System.out.println("Removing score at index " + 3);
        highscores.remove(3);
        System.out.println(highscores);
        System.out.println("Removing score at index " + 0);
        highscores.remove(0);
        System.out.println(highscores);
        System.out.println("Removing score at index " + 1);
        highscores.remove(1);
        System.out.println(highscores);
        System.out.println("Removing score at index " + 1);
        highscores.remove(1);
        System.out.println(highscores);
        System.out.println("Removing score at index " + 0);
        highscores.remove(0);
        System.out.println(highscores);
    }
}
