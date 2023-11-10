package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("start");
        //String[] tabl = {"L", "R", "B", "F"};
        //MoveDirection[] res = OptionParser.metoda(tabl);
       // System.out.println(res);
        run(OptionParser.metoda(args));
        System.out.println("stop");
    }
    public static void run(MoveDirection[] args)
    {
        //System.out.println("start");
        for(MoveDirection moves: args)
        {
            switch(moves) {
                case FORWARD:
                    System.out.println("zwierzak idzie twardo do przodu");
                    break;
                case BACKWARD:
                    System.out.println("zwierzak wykouje taktyczny odwrot");
                    break;
                case RIGHT:
                    System.out.println("zwierzak zakreca w prawo do wiezienia");
                    break;
                case LEFT:
                    System.out.println("zwierzak zakreca w lewo");
                    break;
            }
        }
    }
}
