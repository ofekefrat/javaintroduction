/**
 * This class represents a Point object in the first quadrant of a
 * Cartesian coordinate system.
 * @author Ofek Efrat
 * @version 20-3-2022
 */
public class Point {

    //declarations
    private int _x;
    private int _y;
    private final int DEFAULT_VAL = 0;

    /**
     * Constructs and initializes a point at the specified (x,y) location in
     * the coordinate space. if one of the parameters is negative, it will be
     * initialized to zero instead.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Point(int x, int y) {
        _x = Math.max(x, DEFAULT_VAL);
        _y = Math.max(y, DEFAULT_VAL);
    }

    /**
     * Copy constructor for Point.
     * Construct a point with the same coordinates as another point.
     * @param other The object to be copied
     */
    public Point(Point other) {
        if (other!=null) {
            _x = other._x;
            _y = other._y;
        }
    }

    /**
     * Returns the x coordinate of the point.
     * @return x
     */
    public int getX() {
        return _x;
    }

    /**
     * Returns the y coordinate of the point.
     * @return y
     */
    public int getY() {
        return _y;
    }

    /**
     * Sets the x coordinate of the point.
     * If a negative number is received,
     * The x coordinate does not change.
     * @param x The new x coordinate
     */
    public void setX(int x) {
        if (x >= DEFAULT_VAL) _x = x;
    }

    /**
     * Sets the y coordinate of the point.
     * If a negative number is received,
     * The y coordinate does not change.
     * @param y The new y coordinate
     */
    public void setY(int y) {
        if (y >= DEFAULT_VAL) _y = y;
    }

    /**
     * Moves coordinate x by deltaX and y by deltaY.
     * if one of the given values set the point outside the first quadrant
     * the movement is not allowed.
     * @param dX the amount to move the x coordinate
     * @param dY the amount to move the y coordinate.
     */
    public void move(int dX, int dY) {
        if ((_x + dX) >= DEFAULT_VAL && (_y + dY) >= DEFAULT_VAL) {
            _x += dX;
            _y += dY;
        }
    }

    /**
     * Returns the string representations of the point's coordinates.
     * @return coordinates
     */
    @Override
    public String toString() {
        return "("+ _x +","+ _y +")";
    }

    /**
     * Prints the point coordinates in a specific format (x,y)
     */
    public void printStatus() {
        System.out.println(this);
    }

    /**
     * Checks if another point is at the same coordinates.
     * @param other the other point to compare
     * @return bool
     */
    public boolean equals(Point other) {
        return (_x == other._x && _y == other._y);
    }

    /**
     * Checks if another point is above this point.
     * @param other the other point to compare
     * @return bool
     */
    public boolean isAbove(Point other) {
        return (_y > other._y);
    }

    /**
     * Checks if another point is under this point
     * @param other the other point to compare
     * @return bool
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * Checks if another point is to the right of this point.
     * @param other the other point to compare
     * @return bool
     */
    public boolean isRight(Point other) {
        return (_x > other._x);
    }

    /**
     * Checks if another point is to the left of this point.
     * @param other the other point to compare
     * @return bool
     */
    public boolean isLeft(Point other) {
        return other.isRight(this);
    }

    /**
     * Calculates the distance between this point and another point.
     * @param other Other point
     * @return The distance between this point and the other
     */
    public double distance(Point other) {
        //return Math.sqrt((Math.pow((_y - other._y), 2)) + (Math.pow((_x - other._x), 2))); too long man
        double xDist = Math.pow(_x - other._x, 2);
        double yDist = Math.pow(_y - other._y, 2);
        return Math.sqrt(xDist + yDist);
    }
}//end of class
