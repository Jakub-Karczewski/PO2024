package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionParser {
    public static MoveDirection[] metoda(String[] tab) {
        int n = tab.length;
        MoveDirection[] wyn = new MoveDirection[n];
        int ind = 0;
        for (String napis: tab){
            MoveDirection got = switch(napis){
                case "F" -> MoveDirection.FORWARD;
                case "B" -> MoveDirection.BACKWARD;
                case "L" -> MoveDirection.LEFT;
                case "R" -> MoveDirection.RIGHT;
                default -> MoveDirection.FORWARD;
            };
            wyn[ind] = got;
            ind += 1;
        }
        return wyn;
    }
}
