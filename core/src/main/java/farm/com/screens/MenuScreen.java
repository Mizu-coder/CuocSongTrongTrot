package farm.com.screens;

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
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.buttons.Guide;
import farm.com.buttons.Start;
import farm.com.Utils;
import farm.com.buttons.Continue;

public class MenuScreen implements Screen {
    Texture background;
    Stage stage;
    OrthographicCamera camera;
    Master game;
    Start start;
    Continue bContinue;
    Guide guide;
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
        start = new Start(Gdx.graphics.getWidth()/3+32, 200,stage);
        bContinue = new Continue(Gdx.graphics.getWidth()/3+100, 160, stage);
        guide = new Guide(Gdx.graphics.getWidth()/3+100, 120, stage);
        Gdx.input.setInputProcessor(stage);
        start.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.gameScreen);
                start.remove();
            }
        });

        bContinue.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Utils.loadGame(game);
                game.setScreen(game.gameScreen);
            }
        });

        guide.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GuideScreen(game));
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
