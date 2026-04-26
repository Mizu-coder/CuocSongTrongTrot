package farm.com.intv;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class News extends MyActor {
    public News(float x, float y, Stage s){
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("news.png"));
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }
}
