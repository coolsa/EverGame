public interface LevelAspect{
    public LevelMaker maker();
    public String item();
}

public interface LevelMaker{
    public void create_level();
}