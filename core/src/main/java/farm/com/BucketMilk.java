package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.animals.Cow;
import farm.com.screens.Master;

public class BucketMilk extends MyActor{
    public BucketMilk(float x, float y, Cow cow) {
        super(x, y, null);
        textureRegion = new TextureRegion(new Texture("bucket.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(cow.energy >= 50){
                    if(cow.age > 5){
                        GameState.milkTotal += cow.milk;
                        new ShowInfo(getX()+ getWidth() +4,  getY()+ getHeight() + 4, cow.getStage(), "+" + cow.milk + " bucket milk", 8).fadeOut();
                        cow.energy -= 20;
                        cow.age = 1;
                        remove();
                    }
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
//        if(game.clicked == true){
//            Vector2 mousePosition = new Vector2();
//            mousePosition.set(Gdx.input.getX(), Gdx.input.getY());
//            getStage().getViewport().unproject(mousePosition);
//            setPosition(mousePosition.x, mousePosition.y);
//        }
    }
}
