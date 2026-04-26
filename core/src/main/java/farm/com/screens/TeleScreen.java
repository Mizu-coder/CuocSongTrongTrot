package farm.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import farm.com.intv.*;

public class TeleScreen implements Screen {
    Master game;
    Stage stage;
    GlyphLayout layout;
    OrthographicCamera camera;
    Texture options;
    TextButton education;
    TextButton news;
    TextButton tutorial;
    TextButton back;
    Book book;
    Edu edu;
    News ne;
    Tur1 tur1;
    Tur2 tur2;
    Tur3 tur3;
    Tur4 tur4;
    Tur5 tur5;


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


        tur1 = new Tur1(690,423,stage);
        tur2 = new Tur2(690,423,stage);
        tur3 = new Tur3(690,423,stage);
        tur4 = new Tur4(690,423,stage);
        tur5 = new Tur5(660,410,stage);
        tur1.remove();
        tur2.remove();
        tur3.remove();
        tur4.remove();
        tur5.remove();

        back = new TextButton("Back", style);
        back.setPosition(435, 425);

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.homeScreen);
            }
        });



        education = new TextButton("Education",style);
        education.setPosition(500,597);
        education.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                layout.height = 0.4f;
                layout.width = 0.4f;
                //can doi


            }
        });
        edu = new Edu(education.getX()-80,577,stage);
        book = new Book(education.getX()-80,457,stage);
        ne = new News(education.getX()-80,527,stage);

        news = new TextButton("News",style);
        news.setPosition(500,ne.getY()+20);
        news.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                layout.setText(style.font,"tintuc");
                layout.height = 0.4f;
                layout.width = 0.4f;
            }
        });

        tutorial = new TextButton("Cooking tutorial",style);
        tutorial.setPosition(500,book.getY()+20);
        tutorial.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                layout.setText(style.font,"congthuc");
                layout.height = 0.4f;
                layout.width = 0.4f;
            }
        });

        stage.addActor(tutorial);
        stage.addActor(education);
        stage.addActor(news);
        stage.addActor(back);

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
        game.font.draw(game.batch,layout,941,511);
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
