package farm.com.seeds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.screens.Master;

public class Paddy extends MyActor {
    public Paddy(float x, float y, Stage s){
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("packpa.png"));
        setSize(25,27);
        Master.sohat = 6;
    }
}
