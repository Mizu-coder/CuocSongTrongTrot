package farm.com;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PumkinSeed extends MyActor{
    Master game;

    PumkinSeed(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = Utils.seedpacket(0,16,16,16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                game.type = 1;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(game.seedpu == 0){
            game.type = 6;
        }
    }
}
