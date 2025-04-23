package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.inshop.*;

public class ShopScreen implements Screen {
    Master game;
    Texture background;
    Stage stage;
    OrthographicCamera camera;
    GlyphLayout layout;

    GameState gameState;

    PorkButton porkButton;
    MilkButton milkButton;
    EggButton eggButton;

    ChickenButton chickenButton;
    PigButton pigButton;
    CowButton cowButton;
    MedicineButton medicineButton;

    TextButton back;
    MyActor col;

    public ShopScreen(Master game){
        this.game = game;
        stage = new Stage();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        gameState = new GameState();

        layout = new GlyphLayout();

        col = new MyActor(Gdx.graphics.getWidth()/2, 40, stage);
        col.textureRegion = new TextureRegion(new Texture("energy.png"));
        col.setSize(2, 460);
        col.setColor(Color.YELLOW);

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

        porkButton = new PorkButton( 10, Gdx.graphics.getHeight() - 100, stage);
        milkButton = new MilkButton( 10, Gdx.graphics.getHeight() - 200, stage);
        eggButton = new EggButton( 10, Gdx.graphics.getHeight() - 300, stage);

        chickenButton = new ChickenButton( 600, 450, stage);
        pigButton = new PigButton(600, 380, stage);
        cowButton = new CowButton(600, 310, stage);
        medicineButton = new MedicineButton(600, 240, stage);

        stage.addActor(back);

        stage.addListener(new InputListener() {
            private Actor lastActor = null;

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                Actor actor = stage.hit(x, y, true);

                if (lastActor != null && lastActor instanceof MyActor && lastActor != actor) {
                    lastActor.setColor(1, 1, 1, 1); // Trả về màu gốc
                }

                if (actor instanceof MyActor) {
                    actor.setColor(0, 1, 1, 1); // Làm đậm hơn khi chạm vào
                }

                lastActor = actor;
                return super.mouseMoved(event, x, y);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Actor actor = stage.hit(x, y, true);
                if (actor instanceof MyActor) {
                    actor.setColor(1, 0, 0, 1); // Đổi thành màu đỏ khi nhấn vào
                }
                return super.touchDown(event, x, y, pointer, button);
            }
        });
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
        layout.setText(game.font,"$" + GameState.money);
        game.font.draw(game.batch, layout, Gdx.graphics.getWidth() - layout.width, Gdx.graphics.getHeight() - layout.height );
        layout.setText(game.font,"Sell");
        game.font.draw(game.batch, layout, 200, 500);
        layout.setText(game.font,"Buy");
        game.font.draw(game.batch, layout, 700, 500);

        layout.setText(game.font,"" + pigButton.cost);
        game.font.draw(game.batch, layout, 500, 400);
        layout.setText(game.font,"" + chickenButton.cost);
        game.font.draw(game.batch, layout, 500, 470);
        layout.setText(game.font,"" + cowButton.cost);
        game.font.draw(game.batch, layout, 500, 330);
        layout.setText(game.font,"" + medicineButton.cost);
        game.font.draw(game.batch, layout, 500, 260);

        layout.setText(game.font,"" + GameState.totalPork);
        game.font.draw(game.batch, layout, 100, Gdx.graphics.getHeight() - 80);

        layout.setText(game.font,"" + GameState.milkTotal);
        game.font.draw(game.batch, layout, 100, Gdx.graphics.getHeight() - 180);

        layout.setText(game.font,"" + GameState.egg);
        game.font.draw(game.batch, layout, 100, Gdx.graphics.getHeight() - 280);

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
