package farm.com;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Tomato extends MyActor{
    Master game;
    Tomato(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = Utils.seedpacket(16*3,16,16,16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                game.type = 4;
            }
        });
    }
}
