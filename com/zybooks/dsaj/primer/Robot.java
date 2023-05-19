package com.zybooks.dsaj.primer;

/**
 * An example of nested conditional statements
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Robot {
    Door door = new Door();
    public void advance() {}

    public void simple() {
        if (door.isClosed())
            door.open();
        advance();
    }

    public void complex() {
        if (door.isClosed()) {
            if (door.isLocked())
                door.unlock();
            door.open();
        }
        advance();
    }


}


/** Stub with appropriate syntax but no functionality. */
class Door {
    public void open() {}
    public void unlock() {}
    public boolean isClosed() { return true; }
    public boolean isLocked() { return true; }
}

