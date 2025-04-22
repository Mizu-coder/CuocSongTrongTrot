package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.*;
import farm.com.Character;
import farm.com.actors.Weather;
import farm.com.animals.AnimalActor;
import farm.com.animals.Chicken;
import farm.com.animals.Cow;
import farm.com.animals.Pig;
import farm.com.enums.ChooseType;
import farm.com.enums.SeasonType;
import farm.com.seeds.*;

import static farm.com.enums.SeasonType.*;

// Màn hình phần trồng trọt
public class GameScreen implements Screen {
    Stage stage;
    Stage staticStage;
    InputMultiplexer multiplexer;
    OrthographicCamera camera;
    Master game;
    GlyphLayout layout;
    Character famer;
    Array<Soil> soils;
    Array<Plants> listPlants;
    Array<Cage> cages;
    public static Array<Chicken> chickens;
    public static Array<Pig> pigs;
    public static Array<Cow> cows;
    AnimalActor animalActor;

    Shop shop;
    Coin coin;
    int day;
    int timing;

    public static final int WIDTH = 960;
    public static final int HEIGHT = 1080;

    GameState gameState;

    public GameScreen(Master game) {
        this.game = game;
        stage = new Stage();
        staticStage = new Stage();
        soils = new Array<>();
        listPlants = new Array<>();
        cages = new Array<>();
        if(chickens == null) {
            chickens = new Array<>();
        }
        if(pigs == null){
            pigs = new Array<>();
        }
        if(cows == null) {
            cows = new Array<>();
        }

    }
    @Override
    public void show() {
        generateMap();
        famer = new Character(Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/10 + HEIGHT/2,stage,game);
        famer.setSize(50,50);
        day = 1;
        timing = 0;


        // Vài đống rơm
        new Cock(250, HEIGHT - 200, stage, 3);
        new Cock(280, 230, stage, 3);
        new Cock(870, 620, stage, 2);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        layout = new GlyphLayout();

        layout.setText(game.font, "" + GameState.seedpu);
        layout.width = 0.4f;
        layout.height = 0.4f;

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(staticStage);

        coin = new Coin(Gdx.graphics.getWidth() - 950 , Gdx.graphics.getHeight() - 50 , staticStage);
        shop = new Shop(Gdx.graphics.getWidth() - 90, Gdx.graphics.getHeight() - 102, staticStage);

        shop.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new ShopScreen(game));
            }
        });

        Gdx.input.setInputProcessor(multiplexer);


    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 0);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);


        timing++;
        if(timing % (60*5) == 0){
            newDay();
        }

        if ((float) Gdx.graphics.getWidth() / 2 - famer.getWidth() / 2 <= famer.getX() && famer.getX() <= (float) (WIDTH - Gdx.graphics.getWidth() / 2) - famer.getWidth() / 2) {
            stage.getCamera().position.x = famer.getX() + famer.getWidth() / 2;
        } else if ((float) Gdx.graphics.getWidth() / 2 - famer.getWidth() / 2 > famer.getX()) {
            stage.getCamera().position.x = Gdx.graphics.getWidth() / 2f;
        } else if (famer.getX() > (float) (WIDTH - Gdx.graphics.getWidth() / 2) - famer.getWidth() / 2) {
            stage.getCamera().position.x = WIDTH - Gdx.graphics.getWidth() / 2f;
        }
        if ((float) Gdx.graphics.getHeight() / 2 - famer.getHeight() / 2 <= famer.getY() && famer.getY() <= (HEIGHT - (float) Gdx.graphics.getHeight() / 2) - famer.getHeight() / 2) {
            stage.getCamera().position.y = famer.getY() + famer.getHeight() / 2;
        } else if ((float) Gdx.graphics.getHeight() / 2 - famer.getHeight() / 2 > famer.getY()) {
            stage.getCamera().position.y = Gdx.graphics.getHeight() / 2f;
        } else if (famer.getY() > (HEIGHT - (float) Gdx.graphics.getHeight() / 2) - famer.getHeight() / 2) {
            stage.getCamera().position.y = (HEIGHT - (float) Gdx.graphics.getHeight() / 2);
        }

        if(Gdx.input.justTouched()){
            Vector2 mousePosition = new Vector2();
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY());
            stage.getViewport().unproject(mousePosition);
            System.out.println("x = "+mousePosition.x + " y = " + mousePosition.y);
            float x = onSoils(mousePosition.x, mousePosition.y);

            if(x > 0) {
                if(mousePosition.x < x + 48){
                    x = x + 16;
                } else {
                    x = x + 48;
                }

                if (Master.type.equals(ChooseType.PUMKIN) && GameState.seedpu > 0 && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game));
                    GameState.seedpu -= 1;

                }
                if (Master.type.equals(ChooseType.CAROT) && GameState.seedc > 0 && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game));
                    GameState.seedc -= 1;

                }
                if (Master.type.equals(ChooseType.POTATO) && GameState.seedp > 0 && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game));
                    GameState.seedp -= 1;

                }
                if (Master.type.equals(ChooseType.TOMATO) && GameState.seedt > 0 && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game));
                    GameState.seedt -= 1;

                }
                if (Master.type.equals(ChooseType.BEAN) && GameState.seedb > 0 && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16 * 2, stage, game));
                    GameState.seedb -= 1;

                }
            }
        }

        stage.act();
        stage.draw();
        staticStage.act();
        staticStage.draw();
        game.batch.begin();

        layout.setText(game.font, "" + GameState.money);
        game.font.draw(game.batch, layout,coin.getX() + 48,coin.getY() + 2*coin.getHeight()/3);



        float x = Gdx.graphics.getWidth() - 215;
        float y = Gdx.graphics.getHeight() - 5;

        layout.setText(game.font, "" + GameState.soKimTiem);
        game.font.draw(game.batch, layout,x,y);

        x += 40;
        layout.setText(game.font, "" + GameState.seedpu);
        game.font.draw(game.batch, layout,x,y);

        x += 40;
        layout.setText(game.font, "" + GameState.seedc);
        game.font.draw(game.batch, layout,x,y);

        x += 40;
        layout.setText(game.font, "" + GameState.seedp);
        game.font.draw(game.batch, layout,x,y);

        x += 40;
        layout.setText(game.font, "" + GameState.seedt);
        game.font.draw(game.batch, layout,x,y);

        x += 40;
        layout.setText(game.font, "" + GameState.seedb);
        game.font.draw(game.batch, layout,x,y);
        game.batch.end();

    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        stage.clear();
    }

    @Override
    public void dispose() {
    }

    public void generateMap() {
        genBackground();
        float x = 0;
        float y = 0;

        float px = 111;
        float py = 366;

        float cx = 755;
        float cy = 323;

        float cox = 116;
        float coy = 142;

        // Hàng cây
        x = Gdx.graphics.getWidth() / 2.5f;
        y = HEIGHT - 100;
        for(int i = 0; i < 10; i++){
            Master.tree = new Tree(x, y, stage);
            x += MathUtils.random(30, 90);
        }

        // Nhà
        x = 0;
        y = Gdx.graphics.getHeight()/1.65f + HEIGHT / 2;
        Master.home = new Home(x, y, stage,game);

        // Giếng
        x = 200;
        y = 303 + HEIGHT / 2;
        Master.well = new Well(x, y, stage,game);
        new BucketMilk(Master.well.getX() + 64, Master.well.getY(), stage);
        x = Gdx.graphics.getWidth()/2 + 180 ;
        y = 150 + HEIGHT / 2;
        Master.lake = new Lake(x, y, stage);

        x = 0;
        y = 10 + HEIGHT / 2;

        // Ruộng
        for (int i = 0; i < 4; i++) {
            soils.add(new Soil(x, y, stage));
            x += 105;
        }

        // chuồng nuôi
        cages.add(new Cage(0,0, stage, 8));
        cages.add(new Cage(0, 32 * 8, stage, 5));
        cages.add(new Cage(700, 20 * 8, stage, 5));


        // Duong di trong nong trai
        x = 460;
        y = 0;
        for (int i = 0; i < 20; i++) {
            new Ground(x, y, stage, 2);
            new Ground(x + 32, y, stage, 2);
            y += 32;
        }


        x = Gdx.graphics.getWidth() - 240;
        y = Gdx.graphics.getHeight() - 40;

        new Kimtiem(x, y, staticStage);

        x += 40;

        new PumkinSeed(x, y, staticStage);

        x += 40;
        new CarrotSeed(x, y, staticStage);
        x += 40;
        new Potato(x,y,staticStage);
        x += 40;
        new Tomato(x, y, staticStage);
        x += 40;
        new Bean(x, y, staticStage);
        game.weather = new Weather(0,0, staticStage,game);
        game.weather.setPosition(Gdx.graphics.getWidth() - game.weather.getWidth(), 0);
        game.season = new Season(0,0, staticStage);

        if(cows.isEmpty()) {
            cows.add(new Cow(cox, coy, stage));
            cox -= 32;
            coy -= 32;
            cows.add(new Cow(cox, coy, stage));
            cox += 64;
            coy += 32;
            cows.add(new Cow(cox, coy, stage));
            cox -= 96;
            coy -= 96;
            cows.add(new Cow(cox, coy, stage));
        } else {
            for (Cow c: cows) {
                stage.addActor(c);
            }
        }


        if(pigs.isEmpty()) {
            pigs.add(new Pig(px, py, stage));
            px += 32;
            py += 32;
            pigs.add(new Pig(px, py, stage));
            px -= 64;
            py += 32;
            pigs.add(new Pig(px, py, stage));
            px += 32;
            py -= 128;
            pigs.add(new Pig(px, py, stage));
        } else {
            for (Pig p: pigs) {
                stage.addActor(p);
            }
        }

        if(chickens.isEmpty()) {
            chickens.add(new Chicken(cx, cy, stage));
            cx -= 32;
            cy -= 32;
            chickens.add(new Chicken(cx, cy, stage));
            cx += 32;
            cy -= 32 * 3;
            chickens.add(new Chicken(cx, cy, stage));
            cx += 32;
            cy += 32;
            chickens.add(new Chicken(cx, cy, stage));
        } else {
            for (Chicken c: chickens) {
                stage.addActor(c);
            }
        }

    }
    private void genBackground(){
        float x = 0;
        float y = 0;
        for (int i = 0; i < 63; i++) {
            for (int j = 0; j < 34; j++) {
                new PieceGround(x, y, stage);
                y += 32;
            }
            y = 0;
            x += 32;
        }
    }
    private float onSoils(float x, float y){
        for (Soil s: soils) {
            if(s.getBound().contains(x, y)){
                return s.getX();
            }
        }
        return -1;
    }
    private boolean isFree(float x, float y){
        for (Plants p: listPlants) {
            if(p.getBound().contains(x, y)){
                return false;
            }
        }
        return true;
    }

    public void newDay(){
        day++;
        new Day(0,0,staticStage, day);

        for(Chicken c: chickens){
            c.age++;
        }
        for(Pig p: pigs){
            p.age++;
        }
        for(Cow c: cows){
            c.age++;
        }
        game.weather.ranDomWeatherType();
        if(day % 3 == 0){
            switch (game.season.seasonType){
                case SPRING -> game.season.seasonType = SUMMER;
                case AUTUMN -> game.season.seasonType = WINTER;
                case SUMMER -> game.season.seasonType = AUTUMN;
                case WINTER -> game.season.seasonType = SPRING;
            }
        }
       // famer.setPosition(200, 900);
    }
}
