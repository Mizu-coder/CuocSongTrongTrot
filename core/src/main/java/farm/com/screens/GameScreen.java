package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.*;
import farm.com.Character;
import farm.com.actors.LoApTrung;
import farm.com.actors.Weather;
import farm.com.animals.AnimalActor;
import farm.com.animals.Chicken;
import farm.com.animals.Cow;
import farm.com.animals.Pig;
import farm.com.buttons.Save;
import farm.com.enums.*;
import farm.com.inshop.SellButton;
import farm.com.seeds.*;

import static farm.com.enums.SeasonType.*;

// Màn hình phần trồng trọt
public class GameScreen implements Screen {
    public static Stage stage;
     Stage staticStage;
    InputMultiplexer multiplexer;
    OrthographicCamera camera;
    Master game;
    public static GlyphLayout layout;
    Character famer;
    Array<Soil> soils;
    public static Array<Plants> listPlants = new Array<>();;
    public Array<Cage> cages;
    public static Array<Chicken> chickens = new Array<>();;
    public static Array<Pig> pigs = new Array<>();;
    public static Array<Cow> cows = new Array<>();;

    public static Boolean go = false;

    LoApTrung loAp;
    Save save;
    Shop shop;
    Coin coin;
    public int day = 1;
    int timing;
    Text text = Text.GIEO;
    ChooseType chooseType = ChooseType.NOTHING;

    public static Khung khung;

     SellButton sellButton;

    private ShowInfo info;

    TextButton back;


    public static int complete = 0;

    public static final int WIDTH = 960;
    public static final int HEIGHT = 1080;
    public GameScreen(Master game) {
        this.game = game;
        stage = new Stage();
        staticStage = new Stage();
        soils = new Array<>();
        cages = new Array<>();
        sellButton = new SellButton(10000,10000,stage,game);




    }
    @Override
    public void show() {
        generateMap();
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.RED;
        khung = new Khung(1000,1000,staticStage);
        back = new TextButton("Back", style);
        back.setPosition(1000,1000);
        staticStage.addActor(back);
        famer = new Character(Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/10 + HEIGHT/2,stage,game);
        famer.setSize(50,50);
        timing = 0;
        switch (text) {
            case GIEO -> {
                Master.finger = new Finger(290, 750, stage);
            }
        }






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
        coin = new Coin(Gdx.graphics.getWidth() - 400 , Gdx.graphics.getHeight() - 50 , staticStage);
        shop = new Shop(Gdx.graphics.getWidth() - 90, Gdx.graphics.getHeight() - 102, staticStage);
        save = new Save(Gdx.graphics.getWidth() - 90, Gdx.graphics.getHeight() - 102 - shop.getHeight(), staticStage);
        loAp = new LoApTrung(700, 20*20, stage);

        Master.misson = new Misson(Gdx.graphics.getWidth() - 90, Gdx.graphics.getHeight() - 102 - shop.getHeight()-90, staticStage, game);


        save.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Utils.saveGame(game);
            }
        });

        shop.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new ShopScreen(game));
            }
        });

        loAp.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LoApTrungScreen(game));
            }
        });

        info = new ShowInfo(0,0, null, "", 6);
        stage.addListener(new InputListener() {
            private Actor lastActor = null;

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                Actor actor = stage.hit(x, y, true);

                if (lastActor != null && lastActor instanceof MyActor && lastActor != actor) {
                  info.remove();
                }

                if (actor instanceof Plants) {
                    info.text = actor.toString();
                    info.setPosition(actor.getX(), actor.getY() + actor.getHeight() + 16);
                    stage.addActor(info);
                }
                if (actor instanceof AnimalActor) {
                    info.text = actor.toString();
                    info.setPosition(actor.getX(), actor.getY() + actor.getHeight() + 32);
                    stage.addActor(info);
                }

                if (actor instanceof Well || actor instanceof Lake) {
                    info.text = actor.toString();
                    info.setPosition(actor.getX(), y);
                    stage.addActor(info);
                }

                if (actor instanceof LoApTrung) {
                    info.text = actor.toString();
                    info.setPosition(actor.getX(), actor.getY() + actor.getHeight() + 8);
                    stage.addActor(info);
                }
                if(actor instanceof Finger){
                    info.text = actor.toString();
                    info.setPosition(actor.getX(), actor.getY() );
                    stage.addActor(info);
                }

                lastActor = actor;
                return super.mouseMoved(event, x, y);
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
            Master.misson.giaoNV();
            Master.sohieu = (MathUtils.random(1,3));
            Master.sohat = (MathUtils.random(1,5));
            complete = 0;
        }

        if(go){
            back.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    khung.setPosition(1000,1000);
                    back.setPosition(1000,1000);
                    go = false;
                }
            });
            khung.setPosition(Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/14);
            back.setPosition(khung.getWidth() + 50, 475);
        }




        if ((float) Gdx.graphics.getWidth() / 2 - famer.getWidth() / 2 <= famer.getX() && famer.getX() <= (float) (WIDTH - Gdx.graphics.getWidth() / 2) - famer.getWidth() / 2) {
            stage.getCamera().position.x = famer.getX() + famer.getWidth() / 14f;
        } else if ((float) Gdx.graphics.getWidth() / 2 - famer.getWidth() / 2 > famer.getX()) {
            stage.getCamera().position.x = Gdx.graphics.getWidth() / 2f;
        } else if (famer.getX() > (float) (WIDTH - Gdx.graphics.getWidth() / 2) - famer.getWidth() / 2) {
            stage.getCamera().position.x = WIDTH - Gdx.graphics.getWidth() / 14f;
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

            if(x >= 0) {
                if(mousePosition.x < x + 48){
                    x = x + 16;
                } else {
                    x = x + 48;
                }

                if (Master.type.equals(ChooseType.PUMKIN) && GameState.seedpu > 0 && isFree(mousePosition.x, mousePosition.y)) {
//                    plantType = P
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game, 0));
                    GameState.seedpu -= 1;
                    Master.finger.changeText();
                }
                if (Master.type.equals(ChooseType.CAROT) && GameState.seedc > 0 && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game, 0));
                    GameState.seedc -= 1;
                    Master.finger.changeText();
                }
                if (Master.type.equals(ChooseType.POTATO) && GameState.seedp > 0 && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game, 0));
                    GameState.seedp -= 1;
                    Master.finger.changeText();
                }
                if (Master.type.equals(ChooseType.TOMATO) && GameState.seedt > 0 && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16, stage, game, 0));
                    GameState.seedt -= 1;
                    Master.finger.changeText();
                }
                if (Master.type.equals(ChooseType.BEAN) && GameState.seedb > 0 && isFree(mousePosition.x, mousePosition.y)) {
                    listPlants.add(new Plants(x, mousePosition.y - 16 * 2, stage, game, 0));
                    GameState.seedb -= 1;
                    Master.finger.changeText();
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
        if(go){
            Master.misson.choNV();
        }

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
        cages.clear();
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
        y = Gdx.graphics.getHeight()/2.75f + HEIGHT / 2;
        Master.home = new Home(x, y, stage,game);
        Master.home.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new HomeScreen(game));
            }
        });

        // Giếng
        x = 200;
        y = 303 + HEIGHT / 2;
        Master.well = new Well(x, y, stage,game);
        Master.well.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                changeType(ChooseType.WATER);
            }
        });
        x = Gdx.graphics.getWidth()/1.5f + 180 ;
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

        new PumkinSeed(x, y, staticStage).addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                changeType(ChooseType.PUMKIN);
            }
        });

        x += 40;
        new CarrotSeed(x, y, staticStage).addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                changeType(ChooseType.CAROT);
            }
        });;
        x += 40;
        new Potato(x,y,staticStage).addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                changeType(ChooseType.POTATO);
            }
        });
        x += 40;
        new Tomato(x, y, staticStage).addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                changeType(ChooseType.TOMATO);
            }
        });
        x += 40;
        new Bean(x, y, staticStage).addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                changeType(ChooseType.BEAN);
            }
        });
        game.weather = new Weather(0,0, staticStage,game);
        game.weather.setPosition(Gdx.graphics.getWidth() - game.weather.getWidth(), 0);
        game.season = new Season(0,0, staticStage);

        if(!listPlants.isEmpty()){
            for (Plants p: listPlants) {
                stage.addActor(p);
            }
        }

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

    private void changeType(ChooseType type){
        switch (type){
            case BEAN -> {
                Master.type = ChooseType.BEAN;
                if(game.wateringCan != null && game.wateringCan.getStage() != null){
                    game.wateringCan.remove();
                }
            }
            case PUMKIN ->{
                Master.type = ChooseType.PUMKIN;
                if(game.wateringCan != null && game.wateringCan.getStage() != null){
                    game.wateringCan.remove();
                }
            }
            case CAROT ->{
                Master.type = ChooseType.CAROT;
                if(game.wateringCan != null && game.wateringCan.getStage() != null){
                    game.wateringCan.remove();
                }
            }
            case POTATO ->{
                Master.type = ChooseType.POTATO;
                if(game.wateringCan != null && game.wateringCan.getStage() != null){
                    game.wateringCan.remove();
                }
            }
            case TOMATO -> {
                Master.type = ChooseType.TOMATO;
                if(game.wateringCan != null && game.wateringCan.getStage() != null){
                    game.wateringCan.remove();
                }
            }
            case WATER -> {
                Master.type = ChooseType.WATER;
                game.wateringCan = new WateringCan(0,0,stage,game);
                Master.finger.tuoi();
            }
        }
    }
}
