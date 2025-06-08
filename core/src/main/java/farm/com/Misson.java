package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.enums.NV;

public class Misson extends MyActor{
    NV nv = NV.NOTHING;
    public Misson(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("misson.png"));
        setSize(84,84);
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
