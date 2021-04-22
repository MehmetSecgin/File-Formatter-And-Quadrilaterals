class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
class Quadrilateral {
    Point s1;
    Point s2;
    Point s3;
    Point s4;

    public Quadrilateral(Point s1, Point s2, Point s3, Point s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
    }

    @Override
    public String toString() {
        return s1 + "," + s2 + "," + s3 + "," + s4;
    }

    public double area() {
        return 0;
    }
}

class Trapezoid extends Quadrilateral {


    private final double basis1;
    private final double basis2;
    private final double height;

    public Trapezoid(Point s1, Point s2, Point s3, Point s4) {
        super(s1, s2, s3, s4);
        height = Math.abs(s2.y - s1.y);
        basis1 = s3.x - s2.x;
        basis2 = s4.x - s1.x;
    }

    public double area() {
        return Math.abs((basis1 + basis2)/2 * height);
    }

    @Override
    public String toString() {
        return  "Trapezoid " +
                "Basis1 = " + basis1 +
                ", Basis2 = " + basis2 +
                ", Height = " + height +
                ", Area = " + area();
    }
}

class Parallelogram extends Trapezoid {
    double width;
    double height;

    public Parallelogram(Point s1, Point s2, Point s3, Point s4) {
        super(s1, s2, s3, s4);
        width = Math.abs(s4.x-s1.x);
        height = Math.abs(s1.y-s2.y);

    }

    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return  "Paralellgoram " +
                "width = " + width +
                ", height = " + height +
                ", area = " + area();
    }
}

class Rectangle extends Parallelogram {


    public Rectangle(Point s1, Point s2, Point s3, Point s4) {
        super(s1, s2, s3, s4);
        width = Math.abs(s4.x-s1.x);
        height = Math.abs(s1.y-s2.y);
    }

    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return  "Rectangle " +
                "width = " + width +
                ", height = " + height +
                ", area = " + area();
    }
}

class Square extends Rectangle {
    private double side;

    public Square(Point s1, Point s2, Point s3, Point s4) {
        super(s1, s2, s3, s4);
        side = s3.x - s1.x;
    }

    public double area() {
        return side * side;
    }

    @Override
    public String toString() {
        return  "Square" +
                " Side width = " + side+
                " Area = " + area();
    }
}

public class Main {
    public static void main(String[] args) {
        Quadrilateral[] quad = {
                new Trapezoid(
                        new Point(0, 0),
                        new Point(1, 1),
                        new Point(3, 1),
                        new Point(4, 0)),

                new Parallelogram(
                        new Point(0, 0),
                        new Point(1, 1),
                        new Point(3, 1),
                        new Point(2, 0)),

                new Rectangle(
                        new Point(0, 0),
                        new Point(0, 1),
                        new Point(2, 1),
                        new Point(2, 0)),

                new Square(
                        new Point(0, 0),
                        new Point(0, 1),
                        new Point(1, 2),
                        new Point(1, 0))
        };
        for (Quadrilateral quadrilateral : quad) {

            System.out.println(quadrilateral);
        }
    }
}
