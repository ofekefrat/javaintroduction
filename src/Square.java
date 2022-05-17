import java.sql.SQLInvalidAuthorizationSpecException;

public class Square extends Shape {
    private int _x;

    public Square() {
        _x = 1;
    }
    public Square(int xA, int xB) {
        super(xA);
        _x = xB;
    }

    @Override
    public int subXhelper() {
        return _x-2;
    }

    @Override
    public void print(int x) {
        System.out.println("Square");
    }
}
