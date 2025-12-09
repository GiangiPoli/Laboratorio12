package it.unibo.es2;

/**
 * Interface defining the logic for a slot-based application.
 */
public interface Logics {

    /**
     * The number of slots.
     *
     * @return the number of slots
     */
    int size();

    /**
     * @param actualValue the value currently set in the position
     * @param x position x
     * @param y positon y
     * @return the new text
     */
    String changeText(String actualValue, int x, int y);

    /**
     * True if it is time to quit (i.e., all slots have the final value).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();
}
