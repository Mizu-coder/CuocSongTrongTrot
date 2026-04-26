package farm.com.intv;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Book extends MyActor {
    public Book(float x, float y, Stage s){
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("book.png"));
        setSize(textureRegion.getRegionWidth()/1.25f,textureRegion.getRegionHeight()/1.25f);
    }
}
