package farm.com.inshop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.animals.Chicken;
import farm.com.animals.Cow;
import farm.com.animals.Pig;
import farm.com.enums.BuyTypeButton;
import farm.com.screens.GameScreen;

public class BuyButton extends MyActor {
    public int cost = 0;
    BuyTypeButton type = BuyTypeButton.CHICKEN;
    Sound ting;
    public BuyButton(float x, float y, Stage s) {
        super(x, y, s);

        ting = Gdx.audio.newSound(Gdx.files.internal("ting.wav"));
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money > cost) {
                    ting.play();
                    GameState.money -= cost;
                    switch (type) {
                        case COW -> {
                            GameScreen.cows.add(new Cow(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), null));
                        }
                        case PIG -> {
                            GameScreen.pigs.add(new Pig(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), null));
                        }
                        case CHICKEN -> {
                            GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), null));
                        }
                        case MEDICINE -> {
                            GameState.soKimTiem += 1;
                        }
                    }
                }
            }
        });
    }
}
