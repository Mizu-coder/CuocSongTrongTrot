package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Utils {
    private static Texture texture = new Texture("tilemap_packed.png");
    private static Texture texture2 = new Texture("spring farm tilemap.png");
    private static Texture texturePlants = new Texture("plants free.png");
    public static TextureRegion getRegion(int x, int y, int width, int height) {
        return new TextureRegion(texture, x, y, width, height);
    }
    public static TextureRegion getRegion2(int x, int y,int width, int height) {
        return new TextureRegion(texture2, x, y,width, height);
    }
    public static TextureRegion getRegionPlants(int x, int y,int width, int height) {
        return new TextureRegion(texturePlants, x, y,width, height);
    }
}
