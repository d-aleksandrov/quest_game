package utils.animation;

import utils.GlobalTimer;
import utils.ITickable;

import javax.swing.*;
import java.util.ArrayList;

public class Animation implements ITickable {
    public ArrayList<AnimationPart> animations;
    public JPanel view;

    private float fullTime = 0;
    private Long stTime = -1L;
    private Long currPartTime = 0L;
    private Long lastShowedTime = 0L;

    private AnimationState state = AnimationState.STOPPED;
    private int curAnimationPos;

    private AnimationProcessor processor;

    public Animation(ArrayList<AnimationPart> animations, JPanel view) {
        this.animations = animations;
        this.view = view;
        this.processor = new AnimationProcessor(view);

        for (AnimationPart element : animations) {
            fullTime += element.t;
        }
    }

    public void start() {
        if (state != AnimationState.PLAYED && animations.size() > 0) {
            curAnimationPos = 0;
            GlobalTimer.add(this);
            processor.addNext(animations.get(0));
            state = AnimationState.PLAYED;
        }
    }

    @Override
    public Boolean tick(Long newTime) {
        if (stTime == -1) {
            lastShowedTime = stTime = newTime;
        }

        currPartTime += newTime - lastShowedTime;
        lastShowedTime = newTime;

        if(currPartTime > processor.currTime())
            currPartTime = (long)processor.currTime();

        processor.update(currPartTime);
        if (currPartTime == processor.currTime()) {
            if (curAnimationPos >= animations.size()-1) {
                state = AnimationState.FINISHED;
                return false;
            } else {
                curAnimationPos++;
                processor.addNext(animations.get(curAnimationPos));
                currPartTime = 0L;
                return true;
            }
        }

        return true;
    }

    @Override
    public Integer getTickPriority() {
        return GlobalTimer.PRIORITY_DEFAULT;
    }
}
