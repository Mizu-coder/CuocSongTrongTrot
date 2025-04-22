package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.animals.ChickCost;
import farm.com.GameState;
import farm.com.animals.CowCost;
import farm.com.animals.PigCost;

public class ShopScreen implements Screen {
    Master game;
    Stage stage;
    OrthographicCamera camera;

    CowCost cowCost;
    ChickCost chickCost;
    PigCost pigCost;

    GlyphLayout layout;
    GlyphLayout layout1;

    GameState gameState;
    public ShopScreen(Master game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        gameState = new GameState();

        layout = new GlyphLayout();
        layout.setText(game.font,"");
        layout1 = new GlyphLayout();
        layout1.setText(game.font,"");
        stage = new Stage();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;
        cowCost = new CowCost(Gdx.graphics.getWidth()/3+16, 140,stage);
        Gdx.input.setInputProcessor(stage);
        cowCost.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.gameScreen);
                game.boughtCO = true;
            }
        });

        TextButton.TextButtonStyle style1 = new TextButton.TextButtonStyle();
        style1.font = game.font;
        style1.fontColor = Color.WHITE;
        chickCost = new ChickCost(Gdx.graphics.getWidth()/5.50f, 140,stage);
        Gdx.input.setInputProcessor(stage);
        chickCost.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.gameScreen);
                game.boughtC = true;
            }
        });

        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.font = game.font;
        style2.fontColor = Color.WHITE;
        pigCost = new PigCost(0, 140,stage);
        Gdx.input.setInputProcessor(stage);
        pigCost.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.gameScreen);
                game.boughtP = true;
            }
        });

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.WHITE);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.draw(game.batch, layout, Gdx.graphics.getWidth()/2 - layout.width/2,Gdx.graphics.getHeight()/2 + 2*layout.height);
        game.font.draw(game.batch, layout1, 0,0);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
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
