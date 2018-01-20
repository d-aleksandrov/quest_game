package utils.animation;

import javax.swing.*;

public class AnimationPart {

    public float t = -1;
    public float x = 0;
    public float y = 0;
    public float a = -1;
    public float w = 1;
    public float h = 1;

    public void saveFrom(JPanel view){
        x = view.getX();
        y = view.getY();

        w = view.getWidth();
        h = view.getHeight();

        a = view.getBackground().getAlpha();
    }
}
