package Entity;

public interface Player {
    float y=0,x=0;
    float speed=1;
    Controller controller = new Controller();

    public void jalan();
}
