package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.enums.BuyTypeButton;

public class MedicineButton extends BuyButton {
    public MedicineButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("kimtiem.png"));
        setSize(32, 32);
        cost = 350;
        type = BuyTypeButton.MEDICINE;
    }
}
