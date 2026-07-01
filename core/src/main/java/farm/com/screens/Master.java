package farm.com.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import farm.com.*;
import farm.com.actors.LoApTrung;
import farm.com.actors.Weather;
import farm.com.enums.ChooseType;
import farm.com.enums.Place;
import farm.com.inhome.*;
import farm.com.soilpaddy.*;
import farm.com.water.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master extends Game {
    //public static Cage cages;
    public SpriteBatch batch;
    public static BitmapFont font;
    public static Lake lake;
    public static Water water;
    public static Water2 water2;
    public static WaterL waterL;
    public static WaterR waterR;
    public static WaterLU waterLU;
    public static WaterDoc waterDoc;
    public static R1 r1;
    public static R2 r2;
    public static R3 r3;
    public static R4 r4;
    public static SoilP soilP;
    public static ChoAn choAn;
    public static Windmills windmills;
    public static Home home;
    public static Well well;
    public static LoApTrung loAp;
    public static Tree tree;
    public static Finger finger;
    public static Wallup wallup;
    public static Wallright wallright;
    public static WallDL wallDL;
    public static Bed bed;
    public static TV tv;
    public static Pic pic;
    public static     Sensor sensor;

    public static Heater heater;
    public static Sofa sofa;
    public static Wall_left wallLeft;
    public static WallDR wallDR;
    public static boolean chai = false;
    public static boolean wa = false;
    public static boolean wea = false;

    public static boolean b;
    public static boolean c;
    public static boolean d;

    public static ChooseType type = ChooseType.NOTHING;

    public int sun = 0;
    public int rai = 0;

    public static int sohieu = 0;
    public static int sohat = 0;

    public static boolean nvb;

    public GameScreen gameScreen;
    public HomeScreen homeScreen;
    public TeleScreen teleScreen;
    public LoApTrungScreen loApTrung;
    MenuScreen menuScreen;
    public Weather weather;
    public Season season;
    public WateringCan wateringCan;
    public static Misson misson;

    public boolean clicked = false;
    private boolean sell = false;

    public static Place place;

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
        homeScreen = new HomeScreen(this);
        teleScreen = new TeleScreen(this);
        loApTrung = new LoApTrungScreen(this);
        this.setScreen(menuScreen);
        nvb = true;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }

}
