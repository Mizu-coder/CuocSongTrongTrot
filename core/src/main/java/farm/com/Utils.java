package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;
import farm.com.screens.Master;
import farm.com.utils.GameStateForSave;

public class Utils {
    private static Texture nc = new Texture("water.jpg");
    private static Texture chic = new Texture("Chicken_run.png");
    private static Texture ch = new Texture("Chick_run.png");
    private static Texture pi = new Texture("Pig_run.png");
    private static Texture pil = new Texture("Piglet_run.png");
    private static Texture co = new Texture("Cow_run.png");
    private static Texture texture = new Texture("tilemap_packed.png");
    private static Texture texture2 = new Texture("spring farm tilemap.png");
    private static Texture texturePlants = new Texture("plants free.png");
    private static Texture seed = new Texture("items free.png");
    public static TextureRegion getRegion(int x, int y, int width, int height) {
        return new TextureRegion(texture, x, y, width, height);
    }
    public static TextureRegion getRegion2(int x, int y,int width, int height) {
        return new TextureRegion(texture2, x, y,width, height);
    }
    public static TextureRegion getRegionPlants(int x, int y,int width, int height) {
        return new TextureRegion(texturePlants, x, y,width, height);
    }
    public static TextureRegion seedpacket(int x, int y, int width, int height) {
        return new TextureRegion(seed,x,y,width,height);
    }
    public static TextureRegion cow(int x, int y, int width, int height) {
        return new TextureRegion(co,x,y,width,height);
    }
    public static TextureRegion piglet(int x, int y, int width, int height) {
        return new TextureRegion(pil,x,y,width,height);
    }
    public static TextureRegion pig(int x, int y, int width, int height) {
        return new TextureRegion(pi,x,y,width,height);
    }
    public static TextureRegion chic(int x, int y, int width, int height) {
        return new TextureRegion(ch,x,y,width,height);
    }
    public static TextureRegion chike(int x, int y, int width, int height) {
        return new TextureRegion(chic,x,y,width,height);
    }
    public static TextureRegion wat(int x,int y,int width, int height){
        return new TextureRegion(nc,x,y,width,height);
    }

    public static void saveGame(Master game) {
        GameStateForSave saveGame = new GameStateForSave(game);
        Json json = new Json();
        String jsonString = json.toJson(saveGame);

        FileHandle fileHandle = Gdx.files.local("data.json") ;
        fileHandle.writeString(jsonString,false, "UTF-8");
    }
    public static void loadGame(Master game) {
        FileHandle file = Gdx.files.local("data.json");
        if (!file.exists()) {
            // do nothing
        } else {
            Json json = new Json();
            GameStateForSave saveGame = json.fromJson(GameStateForSave.class, file.readString("UTF-8"));
            GameState.loadData(game, saveGame);
        }
    }

}
