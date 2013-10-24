package util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LimitTimer {
    private Timer timer;
    private int limit;
    private int count;

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
    }

    public int getTimeLimit() {
        return limit;
    }

    public int getCount() {
        return count;
    }

    public boolean isOutOfTime() {
        return count >= limit;
    }

    public void reset() {
        count = 0;
        timer.restart();
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}
