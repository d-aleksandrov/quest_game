package utils;

public class TestTickElement implements ITickable {

    private Integer priority;

    TestTickElement(int priority) {
        this.priority = priority;
    }

    @Override
    public Boolean tick(Long newTime) {
        System.out.println(priority);
        return true;
    }

    @Override
    public Integer getTickPriority() {
        return priority;
    }
}
