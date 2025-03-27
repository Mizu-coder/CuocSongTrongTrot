package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Home extends MyActor{
    Master game;
    Home(float x, float y, Stage s,Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = Utils.getRegion(0,16*4,16*4,16*4);
        setSize(textureRegion.getRegionWidth()*3, textureRegion.getRegionHeight()*3);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.check = 1;
                GameScreen.day += 1;
                new Day(0,0,s,game);
            }
        });
    }

}
