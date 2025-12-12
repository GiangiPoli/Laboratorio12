package it.unibo.es3;

import java.util.List;

/**
 * Interface to describe the behaviour of the GUI.
 */
public interface Logics {

    /**
     * @param pos to set that position in the local list in case the condition is true
     * @return true if that position is starting with "*"
     */
    String startRandomly(Pair<Integer, Integer> pos);

    /**
     * @param pos is the actual position of the active cells
     * @return the new active cells
     */
    List<List<Boolean>> changeNearCells(Pair<Integer, Integer> pos);

    /**
     * @return true if all the cells are visited, otherwise false
     */
    boolean toQuit();
}
