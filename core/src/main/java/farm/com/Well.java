package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.enums.ChooseType;
import farm.com.screens.Master;

public class Well extends MyActor{
    Master game;


    public Well(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;


        textureRegion = Utils.getRegion(16*8,16*7, 16,16*2);
        setSize(textureRegion.getRegionWidth()*3, textureRegion.getRegionHeight()*4);
    }

    @Override
    public String toString() {
        return "Giếng, click vào đây để lấy nước tưới cây!";
    }
}
