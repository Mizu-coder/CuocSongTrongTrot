package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class TeleScreen implements Screen {
    Master game;
    Stage stage;
    GlyphLayout layout;
    OrthographicCamera camera;
    Texture options;
    TextButton education;
    Texture edu;


    public TeleScreen(Master game) {
        this.game = game;
        stage = new Stage();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        layout = new GlyphLayout();
        layout.setText(game.font,"");
        stage = new Stage();
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;

        options = new Texture("optv.jpg");
        edu = new Texture("edu.png");

        education = new TextButton("Education",style);
        education.setPosition(560,597);

        stage.addActor(education);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.draw(game.batch, layout, Gdx.graphics.getWidth()/2 - layout.width/2,Gdx.graphics.getHeight()/2 + 2*layout.height);
        game.batch.draw(options,400,400);
        game.batch.draw(edu,education.getX()-70,education.getY());
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
