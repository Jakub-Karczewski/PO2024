package agh.ics.oop.model;

public class Animal {
    private Vector2d pos;
    private MapDirection orient;
    public Animal(Vector2d start, MapDirection where){
        this.pos = start;
        this.orient = where;
    }
    public Animal(){
        this.pos = new Vector2d(2, 2);
        this.orient = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "pos=" + pos +
                ", orient=" + orient +
                '}';
    }

    public boolean isAt(Vector2d comp){
        boolean res = (this.pos.getx() == comp.getx() && this.pos.gety() == comp.gety() );
        return res;
    }
    public String show_animal(int i){
        return "zwierze " + i + ": " + this.pos.toString();
    }
    public boolean notborder(int dx, int dy){
        int x_new = this.pos.getx() + dx;
        int y_new = this.pos.gety() + dy;
        return (x_new >= 0 && x_new <= 4 && y_new >= 0 && y_new <= 4);
    }
    public void move(MoveDirection direction){
        if(direction == MoveDirection.LEFT){
            this.orient = this.orient.previous();
        }
        else if(direction == MoveDirection.RIGHT){
            this.orient = this.orient.next();
        }
        else{
            int scalar = 1;
            if(direction == MoveDirection.BACKWARD) {
                scalar = -1;
            }
            //int[] dupa = {1, 2, 3};
            int[] delta = switch(this.orient){
                case NORTH -> new int[]{1 * scalar, 0};
                case SOUTH -> new int[]{-1 * scalar, 0};
                case EAST -> new int[]{0, 1 * scalar};
                case WEST -> new int[] {0, -1 * scalar};
            };
            if(notborder(delta[0], delta[1])){
                Vector2d vec1 = new Vector2d(delta[0], delta[1]);
                this.pos = this.pos.add(vec1);
            }
        }
    }

}