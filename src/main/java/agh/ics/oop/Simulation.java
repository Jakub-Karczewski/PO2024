package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Animal> Animals = new ArrayList<Animal>();
    private List<MoveDirection> moves;
    public  void run(){
        int n = this.Animals.size();
        int m = this.moves.size();
        int j = 0;
        for(int i = 0; i < n; i++){
            System.out.println(Animals.get(i).show_animal(i));
        }
        for(int i = 0; i < m; i++){
            MoveDirection turn = moves.get(i);
            if(j == n){
                j = 0;
            }
            Animals.get(j).move(turn);
            System.out.println(Animals.get(j).show_animal(j));
            j += 1;
        }
    }

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        this.moves = moves;
        for(int i = 0; i < positions.size(); i++){
            Vector2d pos = positions.get(i);
            Animal zwierze = new Animal(pos, MapDirection.NORTH);
            this.Animals.add(zwierze);
        }
        this.moves = moves;
    }
}
