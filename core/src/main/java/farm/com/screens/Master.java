package farm.com.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import farm.com.*;
import farm.com.actors.Weather;
import farm.com.enums.ChooseType;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master extends Game {
    //public static Cage cages;
    public SpriteBatch batch;
    BitmapFont font;
    public static Lake lake;
    public static Home home;
    public static Well well;
    public static Tree tree;
    public static Finger finger;


    public static ChooseType type = ChooseType.NOTHING;

    public int sun = 0;
    public int rai = 0;

    public GameScreen gameScreen;
    MenuScreen menuScreen;
    public Weather weather;
    public Season season;
    public WateringCan wateringCan;

    public boolean clicked = false;

    @Override
    public void create() {

        batch = new SpriteBatch();

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 20;
        fontParameters.color = Color.YELLOW;
        fontParameters.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

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
