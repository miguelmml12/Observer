package observer;

public class ColorObserver implements Observer {
    private String name;

    public ColorObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String color) {
        System.out.println(name + " ha observado un cambio de color a: " + color);
    }
}
