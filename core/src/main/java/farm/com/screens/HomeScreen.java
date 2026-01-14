package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.inhome.Bed;
import farm.com.inhome.Chair;
import farm.com.inhome.Heater;
import farm.com.inhome.TV;

public class HomeScreen implements Screen {
    Master game;
    Stage stage;
    Texture floor;
    Texture picture;
    Texture sofa;
    Texture table;
    OrthographicCamera camera;
    Bed bed;
    TV tv;
    Chair chair;
    farm.com.Character main;
    Heater heater;
    public HomeScreen(Master game) {
        this.game = game;
        stage = new Stage();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        floor = new Texture("floor.jpg");
        picture = new Texture("pic.png");
        sofa = new Texture("sofa.png");
        table = new Texture("table.png");
        bed = new Bed(1055,290,stage);
        tv = new TV(797,650,stage);
        heater = new Heater(1100,650,stage);
        chair = new Chair(516,630,stage);
        main = new farm.com.Character(1508,945,stage,game);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(floor, 446,269, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/1.5f);
        game.batch.draw(picture,984,779,100, 100);
        game.batch.draw(sofa,737,250,Gdx.graphics.getWidth()/6.85f, Gdx.graphics.getHeight()/6);
        game.batch.draw(table,576,490,Gdx.graphics.getWidth()/7, Gdx.graphics.getHeight()/2.5f);
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

    }

    @Override
    public void dispose() {

    }
}
