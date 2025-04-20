package farm.com.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import farm.com.*;
import farm.com.actors.Weather;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master extends Game {
    //public static Cage cages;
    public SpriteBatch batch;
    BitmapFont font;
    public static Lake lake;
    public static Home home;
    public static Well well;
    public static Tree tree;

    public int type = 0;
    public int seedc = 5;
    public int seedb = 5;
    public int seedp = 5;
    public int seedt = 5;
    public int seedpu = 5;

    public int sun = 0;
    public int rai = 0;

    public boolean water = false;
    GameScreen gameScreen;
    MenuScreen menuScreen;
    public Weather weather;
    public Season season;

    public boolean clicked = false;
    public boolean hadMilk = false;

    @Override
    public void create() {

        batch = new SpriteBatch();

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 20;
        fontParameters.color = Color.YELLOW;
        font = fontGenerator.generateFont(fontParameters);
        fontGenerator.dispose();
        gameScreen = new GameScreen(this);
        menuScreen = new MenuScreen(this);
        this.setScreen(menuScreen);

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }
}
