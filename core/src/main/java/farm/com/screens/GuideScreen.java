package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.MyActor;
import farm.com.Tutorial;
import farm.com.buttons.Guide;

public class GuideScreen implements Screen {
    Master game;
    Stage stage;
    Tutorial tutorial;

    public GuideScreen(Master game){
        this.game = game;
        stage = new Stage();

        tutorial = new Tutorial(Gdx.graphics.getWidth()/4.5f,Gdx.graphics.getHeight()/4,stage);

        MyActor guide = new MyActor(0,0, stage);
       // guide.textureRegion = new TextureRegion(new Texture("guidetext.png"));
        guide.setSize(guide.textureRegion.getRegionWidth(), guide.textureRegion.getRegionHeight());


        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;

        TextButton back = new TextButton("Back", style);
        back.setPosition(Gdx.graphics.getWidth() - 70, 5);

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });
        stage.addActor(back);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BROWN);

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
}
