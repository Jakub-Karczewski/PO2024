package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.PositionAlreadyOccupiedException;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimulationTest {
    @Test
    public void simtest(){
        String[] moves = {"F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "B", "B", "B", "L", "F", "L", "F", "F", "B"};
        RectangularMap zwierz_pocz = new RectangularMap(20, 20, 6);
        Vector2d v1 = new Vector2d(2, 3), v2 = new Vector2d(3, 4), v3 = new Vector2d(6, 8);
        List<Vector2d> start = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int x = i+2, y = 2*i-5;
            start.add(new Vector2d(x, y));
        }
        ConsoleMapDisplay obs1 = new ConsoleMapDisplay(0);
        zwierz_pocz.add_observators(obs1);
        WorldElement z1 = new Animal(v1, MapDirection.NORTH), z2 = new Animal(v2, MapDirection.EAST);
        Animal z3 = new Animal(v3, MapDirection.SOUTH);
        GrassField trawka = new GrassField(5, 7);
        List<WorldElement> animals = List.of(z1, z2, z3);
        for (int i = 0; i < 3; i++){
            trawka.place(animals.get(i));
    }
        List<Vector2d> positions = List.of(new Vector2d(2,2),
                new Vector2d(3,4), new Vector2d(7, 10), new Vector2d (7, 5));

       List<MoveDirection> moves_parsed = OptionParser.parse(moves);
       Simulation JD = new Simulation(start, moves_parsed, trawka);
       JD.run();
       List<Vector2d> lista = new ArrayList<>();
       for(Map.Entry<Vector2d, Animal> entry : trawka.getAnimals().entrySet()) {
           Vector2d key = entry.getKey();
           lista.add(key);
       }
       System.out.println(lista);
       try {
           assertEquals(true, trawka.isOccupied(new Vector2d(6, -2)));
           assertEquals(true, trawka.isOccupied(new Vector2d(7, -5)));
           assertEquals(false, trawka.isOccupied(new Vector2d(4, 0)));
           assertEquals(false, trawka.isOccupied(new Vector2d(5, -3)));
           assertEquals(false, trawka.isOccupied(new Vector2d(5, 5)));
       }
       catch(PositionAlreadyOccupiedException X){
           X.printStackTrace();
       }

    }

}
