package utils;

import utils.animation.Animation;
import utils.animation.AnimationPart;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class GlobalTimer {
    public static final int PRIORITY_DEFAULT = 10;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_HIGH = 100;
    private static ArrayList<ITickable> list = new ArrayList<>();

    public static void add(ITickable element) {
        list.add(element);
        Collections.sort(list, (o1, o2) -> {
            if (o1.getTickPriority() > o2.getTickPriority())
                return -1;
            else
                return 1;
        });
    }


    public static void initialize(int fps) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                tickAll();
            }
        }, 0, 1000 / fps);

        AnimationPart pt_1 = new AnimationPart();
        pt_1.t = 1000;
        pt_1.x = 2;

        AnimationPart pt_2 = new AnimationPart();
        pt_2.t = 2000;
        pt_2.y = 3;

        AnimationPart pt_3 = new AnimationPart();
        pt_3.t = 500;
        pt_3.x = -2;
        pt_3.y = -3;

        ArrayList<AnimationPart> parts = new ArrayList<>();
        parts.add(pt_1);
        parts.add(pt_2);
        parts.add(pt_3);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,100, 100);

        new Animation( parts, panel).start();
    }


    private static int step = 0;
    private static void tickAll() {
    //    System.out.println(step);
        step++;
        ArrayList<ITickable> removedElements = new ArrayList<>();
        Long time = System.currentTimeMillis();
        for (ITickable element : list) {
            if (element != null && element.tick(time) == false)
                removedElements.add(element);
        }

        list.removeAll(removedElements);
    }
}
