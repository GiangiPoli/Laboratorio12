package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Interface to describe the behaviour of the GUI.
 */
public class LogicsImpl implements Logics {

    //Class Fields
    private static final int POSTIONTOCHOOSE = 3;
    private int positionChoosed;
    private final int width;
    private final List<List<Boolean>> table;
    private final Random randomGenerator = new Random();

    //Class Constructor

    /**
     * In the constructor i set my local button list to modify the GUI one.
     * 
     * @param width to save locally the game field width
     */
    public LogicsImpl(final int width) {
        this.width = width;
        this.table = new ArrayList<>();

        //Initializing my table
        for (int i = 0; i < width; i++) {
            this.table.add(new ArrayList<>());
            for (int j = 0; j < width; j++) {
                this.table.get(i).add(false);
            }
        }
    }

    //Class Method 

    /**
     * @InheritDoc
     */
    @Override
    public String startRandomly(final Pair<Integer, Integer> pos) {
        final int value = Math.abs(randomGenerator.nextInt() % width + 1);
        if (positionChoosed < POSTIONTOCHOOSE && value < (width / (width / 2))) {
            this.table.get(pos.x()).set(pos.y(), true);
            positionChoosed++;
            return "*";
        }
        return " ";
    }

    /**
     * @InheritDoc
     */
    @Override
    public List<List<Boolean>> changeNearCells(final Pair<Integer, Integer> pos) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                //Avoiding going out of bound
                if (pos.x() + i >= 0 && pos.x() + i < width && pos.y() + j >= 0 && pos.y() + j < width) {
                    this.table.get(pos.x() + i).set(pos.y() + j, true);
                }
            }
        }
        final List<List<Boolean>> toReturn = new ArrayList<>();
        for (final List<Boolean> list : this.table) {
            toReturn.add(list);
        }
        return toReturn;
    }

    /**
     * @InheritDoc
     */
    @Override
    public boolean toQuit() {
        for (final List<Boolean> list : table) {
            for (final Boolean value : list) {
                if (!value) {
                    return false;
                }
            }
        }
        return true;
    }
}
