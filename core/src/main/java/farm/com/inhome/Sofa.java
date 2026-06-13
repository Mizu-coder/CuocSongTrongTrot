package farm.com.inhome;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Sofa extends MyActor {
    public Sofa(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("sofa.png"));
        setSize(Gdx.graphics.getWidth()/11, Gdx.graphics.getHeight()/6);
    }
    @Override
    public String toString() {
        return "Sofa, hãy đến gần để ngồi và bấm shift để đứng dậy";
    }
}

