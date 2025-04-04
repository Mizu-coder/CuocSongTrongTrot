package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Ground extends MyActor{
    Ground(float x, float y, Stage s, int size) {
        super(x, y, s);
        textureRegion = Utils.getRegion( 48 + 4*16,48,16,16);
        setSize(textureRegion.getRegionWidth()*size, textureRegion.getRegionHeight()*size);
        setColor(1,1,1,0.7f);
    }
}
