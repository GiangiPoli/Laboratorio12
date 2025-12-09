package it.unibo.es1;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final int size;
    private final List<Integer> buttons;
    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.buttons = new LinkedList<>();

        for (int i = 0; i < this.size; i++) {
            this.buttons.add(0);
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
    public List<Integer> values() {
        return this.buttons.stream().sorted().toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        final List<Boolean> enabled = new LinkedList<>();
        for (Integer value : buttons) {
            if (value != this.size) {
                enabled.add(true);
            } else {
                enabled.add(false);
            }
        }

        return enabled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        this.buttons.set(elem, this.buttons.get(elem) + 1);
        return this.buttons.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return this.buttons.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (final Boolean value : enabledStates()) {
            if (value) {
                return false;
            }
        }
        return true;
    }
}
