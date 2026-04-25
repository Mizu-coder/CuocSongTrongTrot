package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.enums.Place;
import farm.com.inhome.*;

public class HomeScreen implements Screen {
    Master game;
    Stage stage;
    Texture floor;
    OrthographicCamera camera;


    farm.com.Character main;
    public HomeScreen(Master game) {
        this.game = game;
        stage = new Stage();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        floor = new Texture("floor.jpg");
        game.wallup = new Wallup(446,733,stage);
        game.wallright = new Wallright(1250,330,stage);
        game.wallLeft = new Wall_left(448,308,stage);
        game.wallDL = new WallDL(520,255,stage);
        game.wallDR = new WallDR(720,260,stage);
        game.pic = new Pic(984,779,stage);
        game.bed = new Bed(470,555,stage);
        game.tv = new TV(1210,386,stage,game);
        game.heater = new Heater(1100,660,stage);
        game.sofa = new Sofa(471,340,stage);
        game.sensor = new Sensor(615,136,stage);
        main = new farm.com.Character(777,412,stage,game);
        main.setSize(70,80);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        game.place = Place.INHOME;
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(floor, 446,259, Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        if(Gdx.input.justTouched()) {
            Vector2 mousePosition = new Vector2();
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY());
            stage.getViewport().unproject(mousePosition);
            System.out.println("x = " + mousePosition.x + " y = " + mousePosition.y);
        }

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
        game.place = null;
    }

    @Override
    public void dispose() {

    }
}
