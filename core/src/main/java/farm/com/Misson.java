package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.enums.NV;
import farm.com.screens.GameScreen;

public class Misson extends MyActor{
    NV nv = NV.BAN;
    public Misson(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("misson.png"));
        setSize(84, 94);
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                GameScreen.go = true;
            }
        });
    }
    @Override
    public String toString() {
        switch (nv){
            case DONGVAT -> {
                return "Cho động vật ăn";
            }
            case CAY -> {
                return "Trồng 5 cây";
            }
            case BAN -> {
                return "Bán 5 thứ bất kì";
            }
            case NOTHING -> {
                return "Khong co nhiem vu";
            }
        }
        return "";
    }
    public void giaoNV(){
        nv = NV.values()[MathUtils.random(0, NV.values().length - 1)];
    }
}
