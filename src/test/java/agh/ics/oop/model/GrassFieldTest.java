package agh.ics.oop.model;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GrassFieldTest {
    @Test
    public void test_range(){
        int j = 0, n = 5000;
        while(j*j< n * 10){ j += 1; }
        GrassField trawa = new GrassField(n);
        trawa.getAnimals();
        for(Map.Entry<Vector2d, WorldElement> entry : trawa.getAnimals().entrySet()) {
            Vector2d key = entry.getKey();
            assertEquals(true, (key.getx() < j && key.gety() < j));
        }
    }
}
