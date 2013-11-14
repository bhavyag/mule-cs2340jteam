package util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * CLASS LIMITTIMER a swing timer that can be configured with a time limit
 */
public class LimitTimer implements Serializable {
    private Timer timer;
    private int limit;
    private int count;
    private static ActionListener defaultListener;

    /**
     * CONSTRUCTOR creates the timer
     * @param limit the number of ticks before the time runs out
     * @param delay the time between ticks (ms)
     * @param listener a listener listening for when the timer ticks
     */
    public LimitTimer(int limit, int delay, ActionListener listener) {
        this.limit = limit;
        this.timer = new Timer(delay, listener);
        this.count = 0;

        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count ++;
            }
        });
        if (defaultListener != null) {
            timer.addActionListener(defaultListener);
        }
    }

    /**
     * METHOD gives the number of elapsed ticks since last reset
     *
     * @return the number of ticks
     */
    public int getCount() {
        return count;
    }

    /**
     * METHOD determines whether time has run out
     *
     * @return true if time has run out, false otherwise
     */
    public boolean isOutOfTime() {
        return count >= limit;
    }

    /**
     * METHOD resets the timer
     */
    public void reset() {
        count = 0;
        timer.restart();
    }

    /**
     * METHOD starts the timer
     */
    public void start() {
        timer.start();
    }

    /**
     * METHOD stops the timer
     */
    public void stop() {
        timer.stop();
    }

    /**
     * METHOD calculates the amount of time left on the timer
     * @return the time remaining
     */
    public int getTimeRemaining() {
        return limit - count;
    }

    /**
     * METHOD sets a default listener that will be applied to all instances of the timer
     * @param listener the default listener
     */
    public static void setDefaultListener(ActionListener listener) {
        defaultListener = listener;
    }
}
