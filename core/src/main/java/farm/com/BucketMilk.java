package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BucketMilk extends MyActor{
    public BucketMilk(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("bucket.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
    }
}
