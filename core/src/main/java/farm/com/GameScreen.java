package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.        gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Vector;

public class GameScreen implements Screen {
    Texture background;
    Stage stage;
    OrthographicCamera camera;
    Master game;
    GlyphLayout layout;
    Character famer;


    public GameScreen(Master game) {
        this.game = game;
        stage = new Stage();
    }
    @Override
    public void show() {
        generateMap();
        famer = new Character(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2,stage,game);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 0);


        if(Gdx.input.justTouched()){
            Vector2 mousePosition = new Vector2();
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY());
            stage.getViewport().unproject(mousePosition);
            new Plants(mousePosition.x, mousePosition.y, stage);
        }

        stage.act();
        stage.draw();
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

    }

    @Override
    public void dispose() {

    }

    public void generateMap() {
        float x = 0;
        float y = Gdx.graphics.getHeight() / 2;
        for (int i = 0; i < 40; i++) {
            for (int t = 0; t < 50; t++) {
                new Grass(x, y, stage);
                x += 32;
            }
            y += 32;
            x = 0;
        }
        y = Gdx.graphics.getHeight() / 2;
        x = 0;
        for (int i = 0; i < 40; i++) {
            for (int t = 0; t < 50; t++) {
                new Grass(x, y, stage);
                x += 32;
            }
            y -= 32;
            x = 0;
        }
        x = Gdx.graphics.getWidth() / 2.5f;
        y = Gdx.graphics.getHeight()/1.25f;
        for(int i = 0; i < 18; i++){
            Master.tree = new Tree(x, y, stage);
            x += 32;
        }
        x = 0;
        y = Gdx.graphics.getHeight()/1.65f;
        Master.home = new Home(x, y, stage);
        x = 200;
        y = 303;
        Master.well = new Well(x, y, stage);
        x = Gdx.graphics.getWidth()/2f;
        y = Gdx.graphics.getHeight()/40f;
        Master.lake =  new Lake(x, y, stage);
        x = 0;
        y = 10;
        for(int i = 0; i < 8; i++){
            for (int t = 0; t < 14; t++) {
                new Soil(x, y, stage);
                x += 32;
            }
            y += 32;
            x = 0;
        }

    }


}
