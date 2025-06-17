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
    boolean pork = false;
    boolean egg = false;
    boolean milk = false;
    private int t;
    private boolean sell = false;
    Master game;
    public SellButton(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;

        ting = Gdx.audio.newSound(Gdx.files.internal("ting.wav"));
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(pork == true){
                    System.out.println(2);
                    if(GameState.totalPork > 0  ) {
                        GameState.money += cost;
                        pork = false;
                        t += 1;
                        if (t >= 5) {
                            GameState.money += 400;
                        }
                    }
                }

                if(egg == true){
                    System.out.println(0);
                    if (GameState.egg > 0 ){
                        GameState.money += cost;
                        egg = false;
                        t += 1;
                        if (t >= 5) {
                            GameState.money += 400;
                        }
                    }
                }
                if(milk == true){
                    System.out.println(1);
                    if (GameState.milkTotal >0){
                        GameState.money += cost;
                        milk = false;
                        t += 1;
                        if (t >= 5) {
                            GameState.money += 400;
                        }
                    }
                }

                ting.play();

                    switch (type) {
                        case EGG -> {
                            if(GameState.egg > 0){
                                GameState.egg--;
                                egg = true;
                            }

                        }
                        case MILK -> {
                            if (GameState.milkTotal > 0) {
                                GameState.milkTotal--;
                                milk = true;
                            }
                        }
                        case PORK -> {
                            if (GameState.totalPork > 0) {
                                GameState.totalPork--;
                                pork = true;
                            }
                        }
                    }

            }
        });
    }

}
