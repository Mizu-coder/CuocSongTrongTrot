package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Spring extends MyActor{
    TextureRegion spring;
    public Spring(float x, float y, Stage s) {
        super(x, y, s);
        spring = new TextureRegion(new Texture("spring.png"));
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }
}
