package utils.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationProcessor {

    private AnimationPart part;
    private JPanel view;
    private AnimationPart prevtState = new AnimationPart();
    private AnimationPart startState = new AnimationPart();

    public float currTime() {
        if (part != null)
            return part.t;
        else
            return 0;
    }

    public AnimationProcessor(JPanel view) {
        this.view = view;
        startState.saveFrom(view);
    }

    public void addNext(AnimationPart newPart) {
        part = newPart;
        prevtState.saveFrom(view);
    }

    public void update(long time) {
        float progress = ((float) time) / currTime();

        float x = prevtState.x;
        float y = prevtState.y;
        if (part.x != 0) x = x + progress * (prevtState.w * part.x);
        if (part.y != 0) y = y + progress * (prevtState.h * part.y);

        float w = prevtState.w;
        float h = prevtState.h;
        if (part.w != 1) w = prevtState.w * (1 - progress) * part.w;
        if (part.h != 1) h = prevtState.h * (1 - progress) * part.h;

        view.setBounds((int) x, (int) y, (int) w, (int) h);

        trace(progress);
    }

    private void trace(float progress) {
        Rectangle rect = view.getBounds();
        System.out.print(progress);
        System.out.print('\t');
        System.out.print(rect.x);
        System.out.print('\t');
        System.out.print(rect.y);
        System.out.print('\t');
        System.out.print(rect.width);
        System.out.print('\t');
        System.out.println(rect.height);
    }
}
