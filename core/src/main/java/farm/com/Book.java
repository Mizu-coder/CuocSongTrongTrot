package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Book extends MyActor{
    public Book(float x, float y, Stage s){
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("book.png"));
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }
}
