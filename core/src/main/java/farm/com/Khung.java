package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Khung extends MyActor{
    public Khung(float x, float y, Stage s) {
        super(x, y, s);
        setColor(0,0,0,0.5f);
        textureRegion = new TextureRegion(new Texture("energy.png"));
        setSize(Gdx.graphics.getWidth() - 200 , Gdx.graphics.getHeight()- 75);
    }
}
