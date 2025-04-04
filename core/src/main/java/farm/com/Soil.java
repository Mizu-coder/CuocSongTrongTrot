package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Soil extends MyActor{
    TextureRegion t1;
    TextureRegion t2;
    TextureRegion t3;
    TextureRegion t4;
    TextureRegion t5;
    TextureRegion t6;
    TextureRegion t7;
    TextureRegion t8;
    TextureRegion t9;

    Soil(float x, float y, Stage s) {
        super(x, y, s);
        t1 = Utils.getRegion(0,48,16,16);
        t2 = Utils.getRegion(16,48,16,16);
        t3 = Utils.getRegion(32,48,16,16);
        t4 = Utils.getRegion(0,32,16,16);
        t5 = Utils.getRegion(16,32,16,16);
        t6 = Utils.getRegion( 32,32,16,16);
        t7 = Utils.getRegion( 0,16,16,16);
        t8 = Utils.getRegion( 16,16,16,16);
        t9 = Utils.getRegion( 32,16,16,16);
        setSize(32*3, 32*7);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float x = getX();
        float y = getY();
        batch.draw(t1, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t2, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t3, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x = getX();
        y += 32;
        batch.draw(t4, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t5, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t6, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x = getX();
        y += 32;
        batch.draw(t4, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t5, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t6, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x = getX();
        y += 32;
        batch.draw(t4, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t5, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t6, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x = getX();
        y += 32;
        batch.draw(t4, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t5, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t6, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x = getX();
        y += 32;
        batch.draw(t4, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t5, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t6, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());

        x = getX();
        y += 32;
        batch.draw(t7, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t8, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        x += 32;
        batch.draw(t9, x, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
    }
}
