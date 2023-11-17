package agh.ics.oop.model;

public class Vector2d {
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getx() {
        return x;
    }
    private final int x;
    public int gety() {
        return y;
    }
    private final int y;
    public String toString(){
        String str = "(" + x + "," + y + ")";
        return str;
    }
    public boolean precedes(Vector2d vec1){
        boolean czy_git = (this.x <= vec1.x && this.y <= vec1.y);
        return czy_git;
    }
    public boolean follows(Vector2d vec2){
        boolean czy_git = (vec2.x <= this.x && vec2.y <= this.y);
        return czy_git;
    }

    public Vector2d add(Vector2d vec1){
        int x1 = this.x + vec1.x;
        int y1 = this.y + vec1.y;
        Vector2d res = new Vector2d(x1, y1);
        return res;
    }

    public Vector2d subtract(Vector2d other){
        int x1 = this.x - other.x;
        int y1 = this.y - other.y;
        Vector2d res = new Vector2d(x1, y1);
        return res;
    }
    public Vector2d upper_right(Vector2d other){
        int x_max = Math.max(other.x, this.x);
        int y_max = Math.max(other.y, this.y);
        Vector2d upper = new Vector2d(x_max, y_max);
        return upper;
    }
    public Vector2d lower_left(Vector2d other) {
        int x_min = Math.min(other.x, this.x);
        int y_min = Math.min(other.y, this.y);
        Vector2d lower = new Vector2d(x_min, y_min);
        return lower;
    }
    public Vector2d opposite(){
        Vector2d opp = new Vector2d((-1) * this.x, (-1) * this.y);
        return opp;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Vector2d){
            Vector2d vec_other = (Vector2d) other;
            return (this.x == vec_other.x && this.y == vec_other.y);
        }
        return false;
    }
}

