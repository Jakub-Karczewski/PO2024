package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    public static void main(String[] args) {
        System.out.println("start");
        String[] tabl = {"R", "B", "R", "L", "F", "F", "R", "R", "F", "F", "L", "L", "L", "F", "F", "F", "F", "F", "F", "F",  "F"};
        RectangularMap zwierzeta = new RectangularMap(20, 20, 1);
        GrassField trawa = new GrassField(20, 2);
        ConsoleMapDisplay obs2 = new ConsoleMapDisplay(1);
        ConsoleMapDisplay obs3 = new ConsoleMapDisplay(1);
        //trawa.add_observators(obs2);
        zwierzeta.add_observators(obs3);
        List<MoveDirection> directions = OptionParser.parse(tabl);
        System.out.println(directions);
        run(OptionParser.parse(tabl));
        System.out.println("stop");
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(7, 10), new Vector2d (7, 5));
        List<Vector2d> pos = List.of(new Vector2d(3,25), new Vector2d(1,4), new Vector2d(5, 11));
        List<Simulation> lista = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            List<Vector2d> pozycje = new ArrayList<>();
            int maxi = 30; int mini = -2;
            GrassField mapa_testowa = new GrassField(50, 6);
            for (int j = 0; j < 10; j++){
                int x = (int)Math.floor(Math.random() * (maxi - mini + 1) + mini);
                int y = (int)Math.floor(Math.random() * (maxi - mini + 1 ) + mini);
                pozycje.add(new Vector2d(x, y));
            }
            ConsoleMapDisplay obs_test = new ConsoleMapDisplay(5);
            mapa_testowa.add_observators(obs_test);
            List<MoveDirection> orientacje = new ArrayList<>();
            List<MoveDirection> orient = List.of(MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT);
            for (int j = 0; j < 10; j++){
                int x = (int)Math.floor(Math.random() * (3));
                orientacje.add(orient.get(x));
            }
            Simulation simul = new Simulation(pozycje, orientacje, mapa_testowa);
            lista.add(simul);
        }
        SimulationEngine silnik = new SimulationEngine(lista);
        try{
            silnik.pool();
        }
        catch(InterruptedException exc){
            exc.printStackTrace();
        }
        //Simulation simulation2 = new Simulation(pos, directions, zwierzeta);
        //Simulation simulation1 = new Simulation (positions, directions, trawa);
        //SimulationEngine symulacje = new SimulationEngine(List.of(simulation1, simulation2));
        System.out.println("System zakonczyl dzialanie");

    }
    public static void run(List<MoveDirection> args)
    {
        //System.out.println("start");
        for(int i = 0; i < args.size(); i++)
        {
            MoveDirection moves = args.get(i);
            switch(moves) {
                case FORWARD:
                    //System.out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    //System.out.println("zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    //System.out.println("zwierzak zakreca w prawo");
                    break;
                case LEFT:
                    //System.out.println("zwierzak zakreca w lewo");
                    break;
            }
        }
    }
}
