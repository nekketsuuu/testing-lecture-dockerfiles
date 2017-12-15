import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
    @Test
    public void testForOneExample() {
	Triangle t = new Triangle(0.0, 0.0,
				  1.0, 0.0,
				  0.0, 1.0);
        assertThat(t.getType(), is(Triangle.Type.ISOSCELES));
    }
}
