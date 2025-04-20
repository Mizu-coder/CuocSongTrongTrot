package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sun.tools.javac.Main;

public class MenuScreen implements Screen {
    Texture background;
    Shop shop;
    Stage stage;
    OrthographicCamera camera;
    Master game;
    Start start;
    GlyphLayout layout;

    Music music;


    public MenuScreen(Master game){
        this.game = game;
        stage = new Stage();

        background = new Texture("menu.png");
//        start = new Texture("start.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        layout = new GlyphLayout();
        layout.setText(game.font,"");
        stage = new Stage();
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;
        start = new Start(Gdx.graphics.getWidth()/3+32, 140,stage);
        Gdx.input.setInputProcessor(stage);
        start.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.gameScreen);
                start.remove();
            }
        });

        music = Gdx.audio.newMusic(Gdx.files.internal("Menu.mp3"));
        music.setLooping(true);
        music.play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLUE);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(background, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.font.draw(game.batch, layout, Gdx.graphics.getWidth()/2 - layout.width/2,Gdx.graphics.getHeight()/2 + 2*layout.height);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
//        stage.clear();
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
}
