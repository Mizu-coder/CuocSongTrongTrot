package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

// Màn hình phần trồng trọt
public class GameScreen implements Screen {
    Stage stage;
    Stage staticStage;
    InputMultiplexer multiplexer;
    OrthographicCamera camera;
    Master game;
    GlyphLayout layout;
    GlyphLayout layout2;
    GlyphLayout layout3;
    GlyphLayout layout4;
    GlyphLayout layout5;
    Character famer;

    Array<Soil> soils;
    Array<Plants> listPlants;

    static final int WIDTH = 960;
    static final int HEIGHT = 1080;

    public GameScreen(Master game) {
        this.game = game;
        stage = new Stage();
        staticStage = new Stage();
        soils = new Array<>();
        listPlants = new Array<>();
    }
    @Override
    public void show() {
        generateMap();
        famer = new Character(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2 + HEIGHT/2,stage,game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        layout = new GlyphLayout();
        layout2 = new GlyphLayout();
        layout3 = new GlyphLayout();
        layout4 = new GlyphLayout();
        layout5 = new GlyphLayout();

        layout.setText(game.font, "" + game.seedpu);
        layout.width = 0.4f;
        layout.height = 0.4f;

        layout2.setText(game.font, "" + game.seedc);
        layout2.width = 0.4f;
        layout2.height = 0.4f;

        layout3.setText(game.font, "" + game.seedp);
        layout3.width = 0.4f;
        layout3.height = 0.4f;

        layout4.setText(game.font, "" + game.seedt);
        layout4.width = 0.4f;
        layout4.height = 0.4f;

        layout5.setText(game.font, "" + game.seedb);
        layout5.width = 0.4f;
        layout5.height = 0.4f;

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(staticStage);

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 0);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

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

            if(game.type == 1 && game.seedpu > 0 && onSoils(mousePosition.x, mousePosition.y) && !game.water && isFree(mousePosition.x, mousePosition.y)){
                listPlants.add(new Plants(mousePosition.x-16, mousePosition.y-16, stage,game));
                game.seedpu -= 1;
                layout.setText(game.font, "" + game.seedpu);
            }
            if(game.type == 2 && game.seedc > 0 && onSoils(mousePosition.x, mousePosition.y) && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                listPlants.add(new Plants(mousePosition.x-16, mousePosition.y-16, stage,game));
                game.seedc -= 1;
                layout2.setText(game.font, "" + game.seedc);
            }
            if(game.type == 3&& game.seedp > 0 && onSoils(mousePosition.x, mousePosition.y) && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                listPlants.add(new Plants(mousePosition.x-16, mousePosition.y-16, stage,game));
                game.seedp -= 1;
                layout3.setText(game.font, "" + game.seedp);
            }
            if(game.type == 4 && game.seedt > 0 && onSoils(mousePosition.x, mousePosition.y) && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                listPlants.add(new Plants(mousePosition.x-16, mousePosition.y-16, stage,game));
                game.seedt -= 1;
                layout4.setText(game.font, "" + game.seedt);
            }
            if(game.type == 5 && game.seedb > 0 && onSoils(mousePosition.x, mousePosition.y) && !game.water && isFree(mousePosition.x, mousePosition.y)) {
                listPlants.add(new Plants(mousePosition.x-16, mousePosition.y-16*2, stage,game));
                game.seedb -= 1;
                layout5.setText(game.font, "" + game.seedb);
            }
        }

        stage.act();
        stage.draw();
        staticStage.act();
        staticStage.draw();
        game.batch.begin();
        float x = Gdx.graphics.getWidth() - 175;
        float y = Gdx.graphics.getHeight() - 5;
        game.font.draw(game.batch, layout,x,y);
        x += 40;
        game.font.draw(game.batch, layout2,x,y);
        x += 40;
        game.font.draw(game.batch, layout3,x,y);
        x += 40;
        game.font.draw(game.batch, layout4,x,y);
        x += 40;
        game.font.draw(game.batch, layout5,x,y);
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

        // Giêngs
        x = 200;
        y = 303 + HEIGHT / 2;
        Master.well = new Well(x, y, stage,game);
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
        new Cage(0,0, stage);


        x = Gdx.graphics.getWidth() - 200;
        y = Gdx.graphics.getHeight() - 40;
        new PumkinSeed(x, y, staticStage,game);

        x += 40;
        new CarrotSeed(x, y, staticStage,game);
        x += 40;
        new Potato(x,y,staticStage,game);
        x += 40;
        new Tomato(x, y, staticStage,game);
        x += 40;
        new Bean(x, y, staticStage,game);
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
    private boolean onSoils(float x, float y){
        for (Soil s: soils) {
            if(s.getBound().contains(x, y)){
                return true;
            }
        }
        return false;
    }
    private boolean isFree(float x, float y){
        for (Plants p: listPlants) {
            if(p.getBound().contains(x, y)){
                return false;
            }
        }
        return true;
    }
}
