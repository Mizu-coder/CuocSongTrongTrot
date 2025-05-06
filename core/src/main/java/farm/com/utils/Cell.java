package farm.com.utils;

import com.badlogic.gdx.math.Vector2;

public class Cell {
    public boolean state = false;
    public Vector2 position = new Vector2();
    public Cell(boolean state, Vector2 position){
        this.state = state;
        this.position = position;
    }
}
