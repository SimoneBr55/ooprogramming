package org.nbicocchi.objectoriented.exercises;

import org.junit.Test;
import org.nbicocchi.objectoriented.exercises.StringProcessor;

import static org.junit.Assert.assertEquals;

public class StringProcessorTest {
    @Test
    public void findShortest() {
        String[] v1 = {"Nicola", "Marzia", "Agata", "Dharma"};
        StringProcessor sp1 = new StringProcessor(v1);
        assertEquals(2, sp1.findShortest());
    }

    @Test
    public void search() {
        String[] v1 = {"Nicola", "Marzia", "Agata", "Dharma"};
        StringProcessor sp1 = new StringProcessor(v1);
        assertEquals(2, sp1.search("Agata"));
    }

    @Test
    public void reverse() {
        String[] v1 = {"Nicola", "Marzia", "Agata", "Dharma"};
        StringProcessor sp1 = new StringProcessor(v1);
        sp1.reverse();
        assertEquals(1, sp1.search("Agata"));
    }
}