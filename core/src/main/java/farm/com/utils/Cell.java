package farm.com.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Cell {
    public boolean state = false;
    private Vector2 position;

    public Cell(boolean state, Vector2 position) {
        this.state = state;
        this.position = position;
    }
}
