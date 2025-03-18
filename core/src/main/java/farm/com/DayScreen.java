package farm.com;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Map;

public class DayScreen implements Screen {
    Master game;
    Stage stage;
    public static GlyphLayout layout = new GlyphLayout();
    public DayScreen(Master game) {
        this.game = game;
        stage = new Stage();
    }
    @Override
    public void show() {
        layout = new GlyphLayout();
        layout.setText(game.font,"");
    }

    @Override
    public void render(float v) {

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
