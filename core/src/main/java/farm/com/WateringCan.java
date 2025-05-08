package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import farm.com.screens.Master;
import farm.com.seeds.Plants;

public class WateringCan extends MyActor{
    Master game;
    public int time = 0;
    Texture noWatering;
    Texture watering;
    public WateringCan(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        noWatering = new Texture("binhtuoi.png");
        watering = new Texture("binhdatuoi.png");
        textureRegion = new TextureRegion(noWatering);
        setSize(40, 40);
        setTouchable(Touchable.disabled);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getStage() != null){
            Vector2 mousePosition = new Vector2();
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY());
            getStage().getViewport().unproject(mousePosition);
            setPosition(mousePosition.x, mousePosition.y);
        }

        if(time > 0){
            textureRegion = new TextureRegion(watering);
            time++;
            setSize(60,60);
            if(time == 30){
                time = 0;
            }
        } else {
            textureRegion = new TextureRegion(noWatering);
            setSize(40,40);
        }

    }
}
