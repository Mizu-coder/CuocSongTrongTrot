package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.screens.Master;

public class BucketMilk extends MyActor{
    Master game;
    public BucketMilk(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = new TextureRegion(new Texture("bucket.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.clicked = true;
            }
        });

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(game.clicked == true){
            Vector2 mousePosition = new Vector2();
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY());
            getStage().getViewport().unproject(mousePosition);
            setPosition(mousePosition.x, mousePosition.y);
        }
    }
}
