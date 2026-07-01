package farm.com.inshop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;
import farm.com.screens.Master;

public class SellButton extends MyActor {
    int cost = 0;
    SellTypeButton type;
    Sound ting;
    private boolean sell;
    private int t;
    Master game;
    public SellButton(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;

        ting = Gdx.audio.newSound(Gdx.files.internal("ting.wav"));
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sell = false;
                switch (type) {
                    case EGG -> {
                        if(GameState.egg > 0){
                            GameState.egg--;
                            sell = true;
                        }

                    }
                    case MILK -> {
                        if (GameState.milkTotal > 0) {
                            GameState.milkTotal--;
                            sell = true;
                        }
                    }
                    case PORK -> {
                        if (GameState.totalPork > 0) {
                            GameState.totalPork--;
                            sell = true;
                        }
                    }
                    case PADDY -> {
                        if(GameState.totalPaddy > 0){
                            GameState.totalPaddy--;
                            sell = true;
                        }
                    }
                }
                if (sell) {
                    GameState.money += cost;
                    t++;
                    if (t >= 5) {
                        GameState.money += 400;
                        t = 0;
                    }
                    System.out.println(GameState.money);
                    ting.play();
                }
            }
        });
    }

}
