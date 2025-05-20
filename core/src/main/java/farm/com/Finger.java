package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.enums.Text;
import farm.com.screens.GameScreen;

public class Finger extends MyActor{
    private Text text = Text.NOTHING;
    GameScreen gameScreen;
    public Finger(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Finger.png"));
        setSize(textureRegion.getRegionWidth()/4, textureRegion.getRegionHeight()/4);

    }
    @Override
    public String toString() {
        switch (text){
            case GIEO -> {
                return "Lấy hạt giống rồi bấm vào đây";
            }
            case LAYNUOC -> {
                return "Bấm vào giếng để lấy nước";
            }
            case TUOI -> {
                return "Bấm vào cây để tưới";
            }
        }
        return "";
    }
}
