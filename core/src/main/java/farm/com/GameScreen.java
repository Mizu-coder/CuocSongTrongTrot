package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.        gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    Texture background;
    Stage stage;
    OrthographicCamera camera;
    Master game;
    GlyphLayout layout;
    GlyphLayout layout2;
    GlyphLayout layout3;
    GlyphLayout layout4;
    GlyphLayout layout5;
    Character famer;

    public GameScreen(Master game) {
        this.game = game;
        stage = new Stage();
    }
    @Override
    public void show() {
        generateMap();
        famer = new Character(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2,stage,game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        layout = new GlyphLayout();
        layout2 = new GlyphLayout();
        layout3 = new GlyphLayout();
        layout4 = new GlyphLayout();
        layout5 = new GlyphLayout();

        layout.setText(game.font, "" + game.seedpu);
        layout.width = 0.4f;
        layout.height = 0.4f;

        layout2.setText(game.font, "" + game.seedc);
        layout2.width = 0.4f;
        layout2.height = 0.4f;

        layout3.setText(game.font, "" + game.seedp);
        layout3.width = 0.4f;
        layout3.height = 0.4f;

        layout4.setText(game.font, "" + game.seedt);
        layout4.width = 0.4f;
        layout4.height = 0.4f;

        layout5.setText(game.font, "" + game.seedb);
        layout5.width = 0.4f;
        layout5.height = 0.4f;

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 0);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);



        if(Gdx.input.justTouched()){
            Vector2 mousePosition = new Vector2();
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY());
            stage.getViewport().unproject(mousePosition);

            System.out.println("x = " + Gdx.input.getX() + " y = " + (Gdx.graphics.getHeight() - Gdx.input.getY()));
            if(game.type == 1){
                System.out.println(mousePosition.x + " " + Master.soil.getX() + " " + game.seedpu);
            }
            if(game.type == 1 && game.seedpu > 0
                && 0 < mousePosition.x
                && 14*32 > mousePosition.x
                && 0 < mousePosition.y
                && mousePosition.y < 8*32 && game.water != 1){
                new Plants(mousePosition.x-16, mousePosition.y-16, stage,game);
                game.seedpu -= 1;
                layout.setText(game.font, "" + game.seedpu);
            }
            if(game.type == 2 && game.seedc > 0
                && 0 < mousePosition.x
                && 14*32 > mousePosition.x
                && 0 < mousePosition.y
                && mousePosition.y < 8*32&& game.water != 2) {
                Master.plants = new Plants(mousePosition.x-16, mousePosition.y-16, stage,game);
                game.seedc -= 1;
                layout2.setText(game.font, "" + game.seedc);
            }
            if(game.type == 3&& game.seedp > 0
                && 0 < mousePosition.x
                && 14*32 > mousePosition.x
                && 0 < mousePosition.y
                && mousePosition.y < 8*32&& game.water != 3) {
                Master.plants = new Plants(mousePosition.x-16, mousePosition.y-16, stage,game);
                game.seedp -= 1;
                layout3.setText(game.font, "" + game.seedp);
            }
            if(game.type == 4 && game.seedt > 0
                && 0 < mousePosition.x
                && 14*32 > mousePosition.x
                && 0 < mousePosition.y
                && mousePosition.y < 8*32&& game.water != 4) {
                Master.plants = new Plants(mousePosition.x-16, mousePosition.y-16, stage,game);
                game.seedt -= 1;
                layout4.setText(game.font, "" + game.seedt);
            }
            if(game.type == 5 && game.seedb > 0
                && 0 < mousePosition.x
                && 14*32 > mousePosition.x
                && 0 < mousePosition.y
                && mousePosition.y < 8*32&& game.water != 5) {
                Master.plants = new Plants(mousePosition.x-16, mousePosition.y-16*2, stage,game);
                game.seedb -= 1;
                layout5.setText(game.font, "" + game.seedb);
            }
        }

        stage.act();
        stage.draw();
        game.batch.begin();
        game.font.draw(game.batch, layout,235,495);
        game.font.draw(game.batch, layout2,275,495);
        game.font.draw(game.batch, layout3,335,495);
        game.font.draw(game.batch, layout4,232,465);
        game.font.draw(game.batch, layout5,300,465);
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

    public void generateMap() {
        float x = 0;
        float y = Gdx.graphics.getHeight() / 2;
        for (int i = 0; i < 40; i++) {
            for (int t = 0; t < 50; t++) {
                new Grass(x, y, stage);
                x += 32;
            }
            y += 32;
            x = 0;
        }
        y = Gdx.graphics.getHeight() / 2;
        x = 0;
        for (int i = 0; i < 40; i++) {
            for (int t = 0; t < 50; t++) {
                new Grass(x, y, stage);
                x += 32;
            }
            y -= 32;
            x = 0;
        }
        x = Gdx.graphics.getWidth() / 2.5f;
        y = Gdx.graphics.getHeight()/1.25f;
        for(int i = 0; i < 18; i++){
            Master.tree = new Tree(x, y, stage);
            x += 32;
        }
        x = 0;
        y = Gdx.graphics.getHeight()/1.65f;
        Master.home = new Home(x, y, stage);
        x = 200;
        y = 303;
        Master.well = new Well(x, y, stage,game);
        x = Gdx.graphics.getWidth()/2f;
        y = Gdx.graphics.getHeight()/40f;
        Master.lake =  new Lake(x, y, stage);
        x = 0;
        y = 10;
        for(int i = 0; i < 8; i++){
            for (int t = 0; t < 14; t++) {
                Master.soil  = new Soil(x, y, stage);
                x += 32;
            }
            y += 32;
            x = 0;
        }
        x = 205;
        y = 465;
        new PumkinSeed(x, y, stage,game);

        x = 256;
        y = 465;
        new CarrotSeed(x, y, stage,game);
        x = 310;
        y = 465;
        new Potato(x,y,stage,game);
        x = 205;
        y = 435;
        new Tomato(x, y, stage,game);
        x = 273;
        y = 435;
        new Bean(x, y, stage,game);
    }
}
