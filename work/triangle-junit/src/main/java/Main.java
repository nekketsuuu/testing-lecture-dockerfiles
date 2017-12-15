import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
	Triangle t = new Triangle(0.0, 0.0,
				  1.0, 0.0,
				  0.0, 1.0);
	System.out.println(Triangle.toString(t));
	System.out.println(t.getType());
    }
}

class Vec2 {
    // fields
    double x;
    double y;

    // constructors
    
    public Vec2() {
	this.x = ThreadLocalRandom.current().nextDouble();
	this.y = ThreadLocalRandom.current().nextDouble();
    }
    public Vec2(double x, double y) {
	this.x = x;
	this.y = y;
    }

    // utilities
    
    public static String toString(Vec2 p) {
	return String.format("(%f, %f)", p.x , p.y);
    }
}

class Triangle {
    // fields

    Vec2 p1, p2, p3;
    private double d12, d23, d31;
    private final double eps = 1e-10;

    // constructors

    public Triangle() {
	p1 = new Vec2();
	p2 = new Vec2();
	p3 = new Vec2();
	setDistance();
    }
    public Triangle(double x1, double y1,
		    double x2, double y2,
		    double x3, double y3) {
	p1 = new Vec2(x1, y1);
	p2 = new Vec2(x2, y2);
	p3 = new Vec2(x3, y3);
	setDistance();
    }
    private void setDistance() {
	d12 = distance(p1, p2);
	d23 = distance(p2, p3);
	d31 = distance(p3, p1);	
    }
    private static double distance(Vec2 p, Vec2 q) {
	double dx = p.x - q.x;
	double dy = p.y - q.y;
	return Math.sqrt(dx * dx + dy * dy);
    }

    // types of a triangle
    
    public enum Type {
	SCALENE,
	ISOSCELES,
	EQUILATERAL,
	NOTRIANGLE;
    }
    private boolean isTriangle() {
	if (d12 < d23 + d31 && d23 < d31 + d12 && d31 < d23 + d12) {
	    return true;
	} else {
	    return false;
	}
    }
    public Type getType() {
	if (!isTriangle()) {
	    return Type.NOTRIANGLE;
	}

	boolean eq1 = (d12 - d23 < eps);
	boolean eq2 = (d23 - d31 < eps);
	boolean eq3 = (d31 - d12 < eps);
	
	if (eq1 && eq2 && eq3) {
	    return Type.EQUILATERAL;
	} else if (!eq1 && !eq2 && !eq3) {
	    return Type.SCALENE;
	} else {
	    return Type.ISOSCELES;
	}
    }

    // utilities
    
    public static String toString(Triangle t) {
	return String.format("(%s,\n %s,\n %s)",
			     Vec2.toString(t.p1),
			     Vec2.toString(t.p2),
			     Vec2.toString(t.p3));
    }
}
