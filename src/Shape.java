public class Shape {
    private int _x;

    public Shape() {
        _x = 0;
        print(1);
    }

    public Shape(int x) {
        _x = x;
    }

    public int subXhelper() {
        return _x-1;
    }

    public int subX() {
        return subXhelper();
    }

    public void print(int x) {
        System.out.println("Shape");
    }

    public static void main(String[] args) {
        new Square();
    }
}
