package farm.com;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class PieceGround extends MyActor {
    TextureRegion t1;
    TextureRegion t2;
    TextureRegion t3;
    TextureRegion t4;
    TextureRegion t5;
    TextureRegion t6;
    TextureRegion t7;
    TextureRegion t8;

    PieceGround(float x, float y, Stage s) {
        super(x, y, s);
        t1 = Utils.getRegion(0,0,16,16);
        t2 = Utils.getRegion(16,0,16,16);
        t3 = Utils.getRegion(32,0,16,16);
        t4 = Utils.getRegion(48,48,16,16);
        t5 = Utils.getRegion(48 + 16,48,16,16);
        t6 = Utils.getRegion( 48 + 2*16,48,16,16);
        t7 = Utils.getRegion( 48 + 3*16,48,16,16);
        t8 = Utils.getRegion( 48 + 4*16,48,16,16);
        Array<TextureRegion> textureRegionArray = new Array<>();
        textureRegionArray.add(t1);
        textureRegionArray.add(t1);
        textureRegionArray.add(t1);
        textureRegionArray.add(t1);
        textureRegionArray.add(t1);
        textureRegionArray.add(t1);
        textureRegionArray.add(t2);
        textureRegionArray.add(t3);
        textureRegionArray.add(t8);

        textureRegion = textureRegionArray.random();
        setSize(32, 32);
    }
}
