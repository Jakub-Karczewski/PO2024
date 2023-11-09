package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionParser {
    public static MoveDirection[] metoda(String[] tab) {
        return Arrays.stream(tab)
                .filter((param) -> param.equals("F") || param.equals("B") || param.equals("L") || param.equals("R"))
                .map((param) -> {
                    return switch (param) {
                        case "F" -> MoveDirection.FORWARD;
                        case "B" -> MoveDirection.BACKWARD;
                        case "L" -> MoveDirection.LEFT;
                        case "R" -> MoveDirection.RIGHT;
                        default -> MoveDirection.FORWARD;
                    };
                }).toArray(MoveDirection[]::new);
    }
}
