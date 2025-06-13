package farm.com;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import farm.com.screens.GameScreen;

public class MyActor extends Actor {
    public TextureRegion textureRegion;
    public MyActor(float x, float y, Stage s){
        setPosition(x, y);
        if(s != null) {
            s.addActor(this);
        }
        textureRegion = Utils.getRegion(0, 0, 1,1);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(GameScreen.go && getTouchable().equals(Touchable.enabled)){
            setTouchable(Touchable.disabled);
        } else if (!GameScreen.go && getTouchable().equals(Touchable.disabled)) {
            setTouchable(Touchable.enabled);
        }

        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1); // Reset lại màu batch để tránh ảnh hưởng đến các Actor khác}
    }

    public Rectangle getBound(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
