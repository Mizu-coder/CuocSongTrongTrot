package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.actors.TrungDeAp;
import farm.com.animals.Chicken;
import farm.com.inshop.*;
import farm.com.utils.Cell;

public class LoApTrungScreen implements Screen {
    Master game;
    Stage stage;
    GlyphLayout layout;

    Texture oga;
    Texture chicken;

    TextButton back;

    MyActor putInButton;
    Array<Cell> cells;

    public LoApTrungScreen(Master game){
        this.game = game;
        stage = new Stage();
        cells = new Array<>();

        layout = new GlyphLayout();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;

        back = new TextButton("Back", style);
        back.setPosition(Gdx.graphics.getWidth() - 70, 5);

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { 
                game.setScreen(game.gameScreen);
            }
        });

        oga = new Texture("oga.png");
        chicken = new Texture("gacon.png");

        putInButton = new MyActor(50, Gdx.graphics.getHeight() - 100, stage);
        putInButton.textureRegion = new TextureRegion(new Texture("farmer.png"));
        putInButton.setSize(64, 64);
        putInButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.egg > 0) {
                    for (Cell c : cells) {
                        if (!c.state) {

                            TrungDeAp trungDeAp = new TrungDeAp(c.position.x, c.position.y, stage);
                            trungDeAp.addListener(new ClickListener(){
                                @Override
                                public void clicked(InputEvent event, float x, float y) {
                                    if(trungDeAp.time > trungDeAp.TIMEUP){
                                        GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), null));
                                        c.state = false;
                                        trungDeAp.remove();
                                    }
                                }
                            });
                            c.state = true;
                            GameState.egg--;
                            break;
                        }
                    }
                }
            }
        });

        float x = 80;
        float y = Gdx.graphics.getHeight() - 250;
        for (int i = 0; i < 8; i++) {
            cells.add(new Cell(false, new Vector2(x, y)));
            x+= 100;
        }

        x = 80;
        y -= 128;
        for (int i = 0; i < 8; i++) {
            cells.add(new Cell(false, new Vector2(x, y)));
            x+= 100;
        }


        stage.addActor(back);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();

        game.batch.draw(oga, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - 100);
        layout.setText(game.font,"LÒ ẤP TRỨNG");

        game.font.draw(game.batch, layout, Gdx.graphics.getWidth()/2 - layout.width/2, Gdx.graphics.getHeight() - 2*layout.height );

        game.batch.end();

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
