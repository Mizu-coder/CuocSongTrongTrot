package farm.com.inshop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;

public class SellButton extends MyActor {
    int cost = 0;
    SellTypeButton type;
    Sound ting;
    public SellButton(float x, float y, Stage s) {
        super(x, y, s);

        ting = Gdx.audio.newSound(Gdx.files.internal("ting.wav"));
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.totalPork > 0 || GameState.egg > 0 || GameState.milkTotal >0) {
                    GameState.money += cost;
                }
                ting.play();


                    switch (type) {
                        case EGG -> {
                            if(GameState.egg > 0){
                                GameState.egg--;
                            }

                        }
                        case MILK -> {
                            if (GameState.milkTotal > 0) {
                                GameState.milkTotal--;
                            }
                        }
                        case PORK -> {
                            if (GameState.totalPork > 0) {
                                GameState.totalPork--;
                            }
                        }
                    }

            }
        });
    }
}
