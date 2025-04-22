package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.enums.ChooseType;
import farm.com.screens.Master;

public class Kimtiem extends MyActor{
    public Kimtiem(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("kimtiem.png"));
        setSize(32, 32);

        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                Master.type = ChooseType.KIMTIEM;
            }
        });
    }
}
