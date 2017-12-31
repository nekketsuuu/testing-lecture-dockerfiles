import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
    // Very simple test
    @Test
    public void testForOneExample() {
	Triangle t = new Triangle(0.0, 0.0,
				  1.0, 0.0,
				  0.0, 1.0);
        assertThat(t.getType(), is(Triangle.Type.ISOSCELES));
    }

    // Branch coverage
    // (Also, this is a kind of equivalence partitioning)
    @Test
    public void testForEachTypeByOneExample() {
	Triangle scalene = new Triangle(0.0, 0.0,
					1.0, 0.0,
					0.0, 2.0);
	Triangle isosceles = new Triangle(0.0, 0.0,
					  1.0, 0.0,
					  1.0, 1.0);
	Triangle equilateral = new Triangle(0.0, 0.0,
					    2.0, 0.0,
					    1.0, Math.sqrt(3.0));
	Triangle notriangle = new Triangle(0.0, 0.0,
					   1.0, 0.0,
					   -1.0, 0.0);
	assertThat(scalene.getType(), is(Triangle.Type.SCALENE));
	assertThat(isosceles.getType(), is(Triangle.Type.ISOSCELES));
	assertThat(equilateral.getType(), is(Triangle.Type.EQUILATERAL));
	assertThat(notriangle.getType(), is(Triangle.Type.NOTRIANGLE));
    }

    // Equivalence partitioning (more robust)
    @Test
    public void testEquivalencePartitioning() {
	testForEachTypeByOneExample();

	Triangle allSame = new Triangle(0.0, 0.0,
					0.0, 0.0,
					0.0, 0.0);
	Triangle twoSame1 = new Triangle(0.0, 0.0,
					 0.0, 0.0,
					 1.0, 1.0);
	Triangle twoSame2 = new Triangle(0.0, 0.0,
					 1.0, 1.0,
					 0.0, 0.0);
	Triangle twoSame3 = new Triangle(1.0, 1.0,
					 0.0, 0.0,
					 0.0, 0.0);
	assertThat(allSame.getType(), is(Triangle.Type.NOTRIANGLE));
	assertThat(twoSame1.getType(), is(Triangle.Type.NOTRIANGLE));
	assertThat(twoSame2.getType(), is(Triangle.Type.NOTRIANGLE));
	assertThat(twoSame3.getType(), is(Triangle.Type.NOTRIANGLE));
    }

    // Boundary value analysis
    @Test
    public void testBoundary() {
	Triangle small = new Triangle(0.0, 0.0,
				      Float.MIN_NORMAL, 0.0,
				      0.0, Float.MIN_NORMAL);
	Triangle large1 = new Triangle(0.0, 0.0,
				       Float.MAX_VALUE, 0.0,
				       0.0, Float.MAX_VALUE);
	Triangle large2 = new Triangle(0.0, 0.0,
				       Math.sqrt(Float.MAX_VALUE), 0.0,
				       0.0, Math.sqrt(Float.MAX_VALUE));
	Triangle large3 = new Triangle(0.0, 0.0,
				       Float.MAX_VALUE, 0.0,
				       0.5 * Float.MAX_VALUE, Math.sqrt(3.0) * 0.5 * Float.MAX_VALUE);
	assertThat(small.getType(), is(Triangle.Type.ISOSCELES));
	assertThat(large1.getType(), is(Triangle.Type.ISOSCELES));
	assertThat(large2.getType(), is(Triangle.Type.ISOSCELES));
	assertThat(large3.getType(), is(Triangle.Type.EQUILATERAL));
    }

}
