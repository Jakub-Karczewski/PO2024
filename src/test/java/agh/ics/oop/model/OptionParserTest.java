package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import agh.ics.oop.OptionParser;

public class OptionParserTest {
    @Test
    public void Test_OptionsParser() {
        MoveDirection[] zbior = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        List<MoveDirection> my_list = new ArrayList<MoveDirection>();
        for (int i = 0; i < 4; i++){
            my_list.add(zbior[i]);
        }
        String[] args = {"F", "B", "R", "L"};
        List<MoveDirection> res = OptionParser.parse(args);
        assertEquals(my_list, res);

    }
}



