public class Circle {
    //class attributes
    private static final int DEFAULT_VAL = 0;
    private static final double DEFAULT_RADIUS = 1.0;
    public static int counter=0;

    //class methods
    public static int getCounter() {
        return counter;
    }

    //instance attributes
    private Point _center;
    private double _radius;

    //constructors
    public Circle(int x, int y, double radius) {
        _center = new Point(x, y);
        _radius = (radius > DEFAULT_VAL) ? radius : DEFAULT_RADIUS;
    }

    public Circle(Point center, double radius) {
        _center = new Point(center);// copy constructor
        _radius = (radius > DEFAULT_VAL) ? radius : DEFAULT_RADIUS;
    }

    public Circle() {
        this(new Point(1, 1), DEFAULT_RADIUS);
    }

    public Circle(Circle other) {
        _center = new Point(other._center);
        _radius = other._radius;
    }

    public Point getCenter() {
        return new Point(_center);
    }

    public double getRadius() {
        return _radius;
    }

    public void setCenter(Point center) {
        if (center != null) _center = new Point(center);
    }

    public void setRadius(double radius) {
        if (radius >= 0) _radius = radius;
    }

    public double perimeter() {
        return 2 * Math.PI * _radius;
    }

    public double area() {
        return (Math.PI * Math.pow(_radius, 2));
    }

    public void move(int deltaX, int deltaY) {
        _center.move(deltaX, deltaY);
    }

    public boolean equals(Circle other) {
        return (_center.equals(other.getCenter()) && _radius == other.getRadius());
    }

    public boolean isLarger(Circle other) {
        return (_radius > other.getRadius());
    }

    public boolean isSmaller(Circle other) {
        return other.isLarger(this);
    }

    @Override
    public String toString() {
        return ("Center = " + _center +
                "\nRadius = " + _radius);
    }

    public boolean isInCircle(Point p) {
        return (_center.distance(p) <= _radius);
    }
}