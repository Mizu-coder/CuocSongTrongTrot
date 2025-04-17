package farm.com.seeds;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.screens.Master;

public class CarrotSeed extends MyActor {
    Master game;
    public CarrotSeed(float x, float y, Stage s,Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = Utils.seedpacket(16*2,16,16,16);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
        addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y) {
                game.type = 2;
           }
        });
    }

}
