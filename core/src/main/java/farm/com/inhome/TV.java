package farm.com.inhome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.MyActor;
import farm.com.screens.Master;
import farm.com.screens.TeleScreen;

public class TV extends MyActor {
    Master game;
    public TV(float x, float y, Stage s,Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = new TextureRegion(new Texture("tv.png"));
        setSize(textureRegion.getRegionWidth()/1.5f,textureRegion.getRegionHeight()/1.5f);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println(33);
                game.setScreen(game.teleScreen);

            }
        });
    }
}
