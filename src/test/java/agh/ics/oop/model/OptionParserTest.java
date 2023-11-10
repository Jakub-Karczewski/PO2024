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
        MoveDirection[] my_list = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        String[] args = {"F", "B", "R", "L"};
        MoveDirection[] res = OptionParser.metoda(args);
       for(int i = 0; i < 4; i+= 1){
           assertEquals(res[i], my_list[i]);
       }

    }
}



