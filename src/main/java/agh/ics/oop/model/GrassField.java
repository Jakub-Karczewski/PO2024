package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrassField extends AbstractWorldMap{
    int count;
    public GrassField(int num){
        this.count = num;
        int j = 0;
        while(j*j < num*10){
            j+= 1;
        }
        int[][] coord = new int[num][2];
        boolean[][] select = new boolean[j][j];
        int count = 0;
        SecureRandom rand = new SecureRandom();
        while(count < num){
            int x = rand.nextInt(j); int y = rand.nextInt(j);
            if(!select[x][y]){
                select[x][y] = true;
                coord[count][0] = x; coord[count][1] = y; count += 1;
                Vector2d vec = new Vector2d(x, y);
                elements.put(vec, new Grass(vec));
            }
        }

        //List<Vector2d> lista = new ArrayList<>();
        //for(Map.Entry<Vector2d, WorldElement> entry : elements.entrySet()){
            //Vector2d key = entry.getKey();
            //lista.add(key);
        //}
        //System.out.println(lista);

    }
    public String toString(AbstractWorldMap animals){
        MapVisualizer field = new MapVisualizer(animals, this);
        return field.draw();
    }

    public int getCount() {
        return count;
    }

    public HashMap<Vector2d, WorldElement> getmap(){
        return this.getElements();
    }
}
