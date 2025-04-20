package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.enums.SeasonType;

public class Season extends MyActor{
    public SeasonType seasonType = SeasonType.SPRING;
    public Season(float x, float y, Stage s) {
        super(x, y, s);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        switch (seasonType){
            case SPRING -> textureRegion = new TextureRegion(new Texture("spring.png"));
            case AUTUMN -> textureRegion = new TextureRegion(new Texture("autumn.png"));
            case WINTER -> textureRegion = new TextureRegion(new Texture("winter.png"));
            case SUMMER -> textureRegion = new TextureRegion(new Texture("summer.png"));

            default -> textureRegion = new TextureRegion(new Texture("spring.png"));

        }
        setSize(textureRegion.getRegionWidth()/2,textureRegion.getRegionHeight()/2);
    }
}
