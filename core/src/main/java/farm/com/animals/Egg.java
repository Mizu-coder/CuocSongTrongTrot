package farm.com.animals;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.ShowInfo;

public class Egg extends MyActor {
    public Egg(float x, float y, Chicken chicken) {
        super(x, y, null);
        textureRegion = new TextureRegion(new Texture("egg1.png"));
        setSize(16,16);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(chicken.age > 5){
                    GameState.egg++;
                    chicken.age = 1;
                    new ShowInfo(getX()+ getWidth() +4,  getY()+ getHeight() + 4, chicken.getStage(), "+1 egg", 8).fadeOut();
                    remove();
                }
            }
        });
    }
}
