package agh.ics.oop.model;

public class Animal implements WorldElement {
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
        return "N";
        //"Animal{" +
                //"pos=" + pos +
                //", orient=" + orient +
                //'}';
    }
    public boolean isAt(Vector2d comp){
        boolean res = (this.pos.getx() == comp.getx() && this.pos.gety() == comp.gety() );
        return res;
    }
    public String show_animal(int i){
        return "zwierze " + i + ": " + this.pos.toString();
    }
    public boolean notborder(int dx, int dy, int[] X, int[] Y){
        int x_new = this.pos.getx() + dx;
        int y_new = this.pos.gety() + dy;
        return (x_new >= X[0] && x_new <= X[1] && y_new >= Y[0] && y_new <= Y[1]);
    }
    public Vector2d getPos() {
        return pos;
    }

    public MapDirection getOrient() {
        return orient;
    }
    public void move(MoveDirection direction, MoveValidator JD){
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
            int[] delta = switch(this.orient){
                case NORTH -> new int[]{1 * scalar, 0};
                case SOUTH -> new int[]{-1 * scalar, 0};
                case EAST -> new int[]{0, 1 * scalar};
                case WEST -> new int[] {0, -1 * scalar};
            };
            Vector2d vec1 = new Vector2d(delta[0], delta[1]);
            Vector2d check = new Vector2d(this.pos.getx(), this.pos.gety());
            if(JD.canMoveTo(check.add(vec1))){
                this.pos = this.pos.add(vec1);
            }
        }
    }

}
