package org.nbicocchi.objectoriented.exercises;

import org.junit.Test;
import org.nbicocchi.objectoriented.exercises.Vector;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void sort() {
        Vector v = new Vector(new int[] {1, 5, 55, 3, 88});
        v.sort();
        assertArrayEquals(new int[] {1, 3, 5, 55, 88}, v.v);
    }

    @Test
    public void search() {
        Vector v = new Vector(new int[] {1, 5, 55, 3, 88});
        assertEquals(0, v.search(1));
        assertEquals(4, v.search(88));
        assertEquals(-1, v.search(2));
    }
}