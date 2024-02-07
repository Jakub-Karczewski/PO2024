package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {
    private List<Animal> Animals = new ArrayList<>();
    private List<MoveDirection> moves;
    private AbstractWorldMap mapa;

    public void run() {
        int n = this.Animals.size(), m = moves.size();
        int j = 0;
        for (int i = 0; i < m; i++) {
            MoveDirection turn = moves.get(i);
            if (j == n) {
                j = 0;
            }
            Animals.get(j).move(turn, mapa);
            System.out.println(Animals.get(j).show_animal(j));
            j += 1;
        }
        for (int i = 0; i < n; i++) {
            mapa.place(Animals.get(i));
        }
        System.out.println();
        Boundary granica = mapa.getCurrentBonds();
        System.out.print(mapa.toString());
    }

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, AbstractWorldMap mapa) {
        this.moves = moves;
        for (int i = 0; i < positions.size(); i++) {
            Vector2d pos = positions.get(i);
            Animal zwierze = new Animal(pos, MapDirection.NORTH);
            this.Animals.add(zwierze);
        }
        this.mapa = mapa;
        this.moves = moves;
    }
    public AbstractWorldMap getMapa() {
        return mapa;
    }
}


