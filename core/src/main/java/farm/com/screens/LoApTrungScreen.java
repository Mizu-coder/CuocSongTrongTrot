package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.inshop.*;

public class LoApTrungScreen implements Screen {
    Master game;
    Stage stage;
    GlyphLayout layout;

    Texture egg;
    Texture chicken;

    TextButton back;

    public LoApTrungScreen(Master game){
        this.game = game;
        stage = new Stage();

        layout = new GlyphLayout();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;

        back = new TextButton("Back", style);
        back.setPosition(Gdx.graphics.getWidth() - 70, 5);

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        egg = new Texture("egg.png");
        chicken = new Texture("gacon.png");


        stage.addActor(back);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);

        stage.act();
        stage.draw();

        game.batch.begin();
        layout.setText(game.font,"LÒ ẤP TRỨNG");

        float x = 80;
        float y = Gdx.graphics.getHeight() - 250;
        for (int i = 0; i < 8; i++) {
            if(i == 2 || i == 5){
                game.batch.draw(chicken, x + 32, y + 32,64, 64);
            } else {
                game.batch.draw(egg, x, y,128, 128);
            }
            x+= 100;
        }
        x = 80;
        y -= 128;
        for (int i = 0; i < 8; i++) {
            if(i == 7){
                game.batch.draw(chicken, x + 32, y + 32,64, 64);
            } else {
                game.batch.draw(egg, x, y,128, 128);
            }
            x+= 100;
        }

        game.font.draw(game.batch, layout, Gdx.graphics.getWidth()/2 - layout.width/2, Gdx.graphics.getHeight() - 2*layout.height );

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

    }

    @Override
    public void dispose() {

    }
}
