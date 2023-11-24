package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Simulation {
    private List<Animal> Animals = new ArrayList<>();
    private List<MoveDirection> moves;
    private WorldMap mapeczka;
    public void run(){
        int n = this.Animals.size();
        int m = this.moves.size();
        int j = 0;
        for(int i = 0; i < m; i++){
            MoveDirection turn = moves.get(i);
            if(j == n){
                j = 0;
            }
            Animals.get(j).move(turn, mapeczka);
            System.out.println(Animals.get(j).show_animal(j));
            j += 1;
        }
        for (int i = 0; i < n; i++){
            mapeczka.place(Animals.get(i));
        }
        for (int i = 0; i < n; i++){
            System.out.println(Animals.get(i).getPos());
        }
        MapVisualizer visual = new MapVisualizer(mapeczka);
        System.out.println(visual.draw(new Vector2d(0, 0), new Vector2d(4, 4)));
    }

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap mapeczka) {
        this.moves = moves;
        for(int i = 0; i < positions.size(); i++)
        {
            Vector2d pos = positions.get(i);
            Animal zwierze = new Animal(pos, MapDirection.NORTH);
            this.Animals.add(zwierze);
        }
        this.mapeczka = mapeczka;
        this.moves = moves;
    }
}
