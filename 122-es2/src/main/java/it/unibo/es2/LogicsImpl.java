package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final int size;
    private final List<List<Boolean>> table;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */

    public LogicsImpl(final int size) {
        this.size = size;
        this.table = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            this.table.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                this.table.get(i).add(false);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String changeText(final String actualValue, final int x, final int y) {
        table.get(x).set(y, true);
        if (" ".equals(actualValue)) {
            return "*";
        } else {
            return " ";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        int counterHorizontal;
        int counterVertical;
        for (int i = 0; i < size; i++) {
            counterHorizontal = 0;
            counterVertical = 0;
            for (int j = 0; j < size; j++) {
                if (this.table.get(i).get(j)) {
                    counterHorizontal++;
                }
                if (counterHorizontal == size()) {
                    return true;
                }
                if (table.get(j).get(i)) {
                    counterVertical++;
                }
                if (counterVertical == size()) {
                    return true;
                }
            }
        }

        return false;
    }

}
