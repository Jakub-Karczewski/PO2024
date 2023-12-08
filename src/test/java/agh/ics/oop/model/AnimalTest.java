package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void Test_move(){
        WorldMap mapa = new RectangularMap();
        Animal zwierze1 = new Animal(new Vector2d(2, 2), MapDirection.NORTH);
        Animal zwierze2 = new Animal(new Vector2d(3, 3), MapDirection.EAST);
        //System.out.println(zwierze1.show_animal(0));
        zwierze1.move(MoveDirection.FORWARD, mapa);
        zwierze1.move(MoveDirection.RIGHT, mapa);
        zwierze1.move(MoveDirection.FORWARD, mapa);
        assertEquals(zwierze1.toString(), zwierze2.toString());
    }
    @Test
    public void Test_notborder(){
        WorldMap mapa = new RectangularMap();
        Animal zwierze1 = new Animal(new Vector2d(4, 3), MapDirection.NORTH);
        Animal zwierze2 = new Animal(new Vector2d(4, 4), MapDirection.EAST);
        zwierze1.move(MoveDirection.FORWARD, mapa);
        zwierze1.move(MoveDirection.RIGHT, mapa);
        zwierze1.move(MoveDirection.FORWARD, mapa);
        zwierze1.move(MoveDirection.FORWARD, mapa);
        assertEquals(zwierze1.toString(), zwierze2.toString());
    }
}




