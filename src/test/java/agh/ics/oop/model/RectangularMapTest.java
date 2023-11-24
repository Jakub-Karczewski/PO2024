package agh.ics.oop.model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class RectangularMapTest {

    public void print_Map(HashMap<Vector2d, Animal> mapka){
        for (HashMap.Entry<Vector2d, Animal> entry : mapka.entrySet()) {
            Vector2d key = entry.getKey();
            Animal zwierzak = entry.getValue();
            System.out.println("Key=" + key + ", Value=" + zwierzak);
        }
    }
    public List<Vector2d> Hashmap_to_list(HashMap<Vector2d, Animal> heh){
        List<Vector2d> lista = new ArrayList<>();
        for(Map.Entry<Vector2d, Animal> entry : heh.entrySet()){
            Vector2d key = entry.getKey();
            lista.add(key);
        }
        return lista;
    }

    @Test
    public void Test_can_move_to(){
        Animal z1 = new Animal(new Vector2d(1, 2), MapDirection.NORTH);
        Animal z2 = new Animal(new Vector2d(1, 2), MapDirection.NORTH);
        Animal z3 = new Animal(new Vector2d(4, 4), MapDirection.NORTH);
        RectangularMap mapa = new RectangularMap(5, 5);
        MoveValidator JD = mapa;
        z1.move(MoveDirection.LEFT, JD);
        z1.move(MoveDirection.FORWARD, JD);
        z2.move(MoveDirection.RIGHT, JD);
        z2.move(MoveDirection.BACKWARD, JD);
        for (int i = 0; i < 5; i++){
            z3.move(MoveDirection.FORWARD, JD);
        }
        mapa.place(z1);
        mapa.place(z2);
        mapa.place(z3);
        HashMap<Vector2d, Animal> hash = mapa.getAnimals();
        //print_Map(mapa.getAnimals());
        List<Vector2d> lista = Hashmap_to_list(hash);
        List<Vector2d> lista_test = List.of(new Vector2d(1, 1), new Vector2d(4, 4));
        assertEquals(lista_test, lista);
        //System.out.println(lista);
    }
    @Test
    public void Test_ObjectAt_IsOccupied() {
        Animal z3 = new Animal(new Vector2d(4, 4), MapDirection.NORTH);
        RectangularMap mapa = new RectangularMap(5, 5);
        mapa.place(z3);
        Vector2d vec = new Vector2d(4, 4);
        //System.out.println(mapa.objectAt(vec));
        assertEquals(z3, mapa.objectAt(new Vector2d(4, 4)));
        //System.out.println(mapa.objectAt(new Vector2d(3, 3)));
        assertEquals(null, mapa.objectAt(new Vector2d(3, 3)));
        assertEquals(true, mapa.isOccupied(vec));
        assertEquals(false, mapa.isOccupied(new Vector2d(2, 2)));
    }
}
