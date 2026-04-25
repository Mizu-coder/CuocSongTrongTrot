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
import farm.com.Book;
import farm.com.Edu;

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
    Texture ne;
    Book book;
    Edu edu;

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
        ne = new Texture("news.png");


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
                layout.setText(style.font,"giaoduc");
                layout.height = 0.4f;
                layout.width = 0.4f;
            }
        });

        news = new TextButton("News",style);
        news.setPosition(500,567);
        news.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                layout.setText(style.font,"tintuc");
                layout.height = 0.4f;
                layout.width = 0.4f;
            }
        });

        tutorial = new TextButton("Cooking tutorial",style);
        tutorial.setPosition(500,537);
        tutorial.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                layout.setText(style.font,"congthuc");
                layout.height = 0.4f;
                layout.width = 0.4f;
            }
        });

        book = new Book(education.getX()-80,527,stage);
        edu = new Edu(education.getX()-80,577,stage);




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
        game.batch.draw(ne,education.getX()-80,527);
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
