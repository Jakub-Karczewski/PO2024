package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Vector2dTest {

    @Test
    public void Test_equals () {
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(1, 1);
        Vector2d c = new Vector2d(1, 2);

        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
    }

    @Test
    public void Test_toString(){
        Vector2d a = new Vector2d(1, 1);

        assertEquals(a.toString(), "(1,1)");
    }

    @Test
    public void Test_precedes() {
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(2, 2);
        Vector2d c = new Vector2d(0, 0);

        assertTrue(a.precedes(b));
        assertFalse(b.precedes(c));
    }

    @Test
    public void Test_follows() {
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(0, 0);
        Vector2d c = new Vector2d(2, 2);

        assertTrue(b.precedes(a));
        assertFalse(c.precedes(b));
    }
    @Test
    public void Test_upperRight() {
        Vector2d a = new Vector2d(1, 4);
        Vector2d b = new Vector2d(2, 3);
        Vector2d solution = a.upper_right(b);
        System.out.println(solution.toString());

        assertEquals(a.upper_right(b).toString(), new Vector2d(2, 4).toString());
    }

    @Test
    public void Test_lowerLeft() {
        Vector2d a = new Vector2d(1, 4);
        Vector2d b = new Vector2d(2, 3);

        assertEquals(a.lower_left(b).toString(), new Vector2d(1, 3).toString());
    }


    @Test
    public void testAdd() {
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(2, 2);

        assertEquals(a.add(b).toString(), new Vector2d(3, 3).toString());
    }

    @Test
    public void testSubtract() {
        Vector2d a = new Vector2d(3, 3);
        Vector2d b = new Vector2d(2, 2);

        assertEquals(a.subtract(b).toString(), new Vector2d(1, 1).toString());
    }

    @Test
    public void Test_opposite() {
        Vector2d a = new Vector2d(1, 1);

        assertEquals(a.opposite().toString(), new Vector2d(-1, -1).toString());
    }
}
