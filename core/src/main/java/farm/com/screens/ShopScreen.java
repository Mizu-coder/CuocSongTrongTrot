package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.Animals;
import farm.com.GameState;
import farm.com.Start;

public class ShopScreen implements Screen {
    Master game;
    Texture background;
    Stage stage;
    OrthographicCamera camera;
    Animals animals;
    GlyphLayout layout;
    GameState gameState;
    public ShopScreen(Master game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        gameState = new GameState();

        layout = new GlyphLayout();
        layout.setText(game.font,"");
        stage = new Stage();
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;
        animals = new Animals(Gdx.graphics.getWidth()/3+32, 140,stage);
        Gdx.input.setInputProcessor(stage);
        animals.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){

            }
        });
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
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
