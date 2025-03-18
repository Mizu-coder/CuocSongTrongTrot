package farm.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master extends Game {
    SpriteBatch batch;
    BitmapFont font;
    Stage s;
    public static Lake lake;
    public static Home home;
    public static Well well;
    public static Tree tree;
    public static Soil soil;
    public static Plants plants;

    int type = 0;
    int seedc = 5;
    int seedb = 5;
    int seedp = 5;
    int seedt = 5;
    int seedpu = 5;

    int water = 0;
    int check = 0;
    @Override
    public void create() {

        batch = new SpriteBatch();

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 20;
        fontParameters.color = Color.YELLOW;
        font = fontGenerator.generateFont(fontParameters);
        fontGenerator.dispose();
        this.setScreen(new MenuScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }
}
