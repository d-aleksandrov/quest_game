package utils;

public class TestAnimatableObject implements ITickable {

    private Long stTime;

    private int duration;
    TestAnimatableObject(int duration){
        this.duration = duration;
    }

    @Override
    public Boolean tick(Long newTime) {
        if(stTime==null)
            stTime = newTime;

        float progress = ((float)(newTime - stTime))/((float)(duration));
        System.out.println(progress);
        return progress<1;
    }

    @Override
    public Integer getTickPriority() {
        return GlobalTimer.PRIORITY_DEFAULT;
    }
}
