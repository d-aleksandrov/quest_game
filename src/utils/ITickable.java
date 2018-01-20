package utils;

public interface ITickable {
    public Boolean tick(Long newTime);
    public Integer getTickPriority();
}
