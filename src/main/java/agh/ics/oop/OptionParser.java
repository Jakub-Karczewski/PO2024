package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class OptionParser {
   /* public static MoveDirection[] metoda(String[] tab) {
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
    */
    public static List<MoveDirection> parse(String[] tab){
        return Arrays.stream(tab)
                .map((param) -> {
                    return switch (param) {
                        case "F" -> MoveDirection.FORWARD;
                        case "B" -> MoveDirection.BACKWARD;
                        case "L" -> MoveDirection.LEFT;
                        case "R" -> MoveDirection.RIGHT;
                        default -> throw new IllegalArgumentException(param + " is not legal move specification");
                    };
                }).toList();
    }
}
