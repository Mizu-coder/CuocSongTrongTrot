package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ShowInfo extends Actor {
    private String text;
    private BitmapFont font;

    public ShowInfo(float x, float y, Stage s, String words, int size) {
        text = words;

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = size;
        fontParameter.color = Color.RED;
        fontParameter.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        setPosition(Gdx.graphics.getWidth()/2,  Gdx.graphics.getHeight()/2);
        setColor(1, 1, 1, 1); // Đảm bảo alpha ban đầu là 1 (không trong suốt)

        toFront();
        s.addActor(this);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.setColor(1, 1, 1, getColor().a * parentAlpha);
        font.draw(batch, text, getX(), getY());
    }

    public void fadeOut(){
        // Hiệu ứng di chuyển lên + làm mờ dần + xóa sau 1 giây
        addAction(Actions.sequence(
            Actions.moveBy(0, 50, 2),  // Bay lên 30 pixel trong 1 giây
            Actions.fadeOut(0.02f),        // Làm mờ trong 1 giây
            Actions.removeActor()       // Xóa khỏi stage
        ));
    }
}
