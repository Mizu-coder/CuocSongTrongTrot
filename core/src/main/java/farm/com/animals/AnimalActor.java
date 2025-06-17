package farm.com.animals;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import farm.com.EnergyBar;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.ShowInfo;
import farm.com.enums.NV;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;

public class AnimalActor extends MyActor {
    NV nv = NV.NOTHING;
    farm.com.enums.AnimalNames name;
    public float energy = 100;
    float minusEnerGy = 0;
    float cost = 100;
    float meat = 0;
    public int milk = 1;
    float sellingPrice = 100;
    public int age;

    ShowInfo infoMeat;
    EnergyBar energyBar;

    boolean ill = false;
    float timeForIll = 0;
    float timeforIllMax = 5;
    int hour = 0;
    boolean touched = false;
    float lastX = 0;
    float lastY = 0;
    AnimalActor(float x, float y, Stage s) {
        super(x, y, s);

        addListener(new DragListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(!touched){
                    touched = true;
                    lastX = x;
                    lastY = y;
                }
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if(touched) {
                    float deltaX = x - lastX;
                    float deltaY = y - lastY;
                    moveBy(deltaX, deltaY);

                    lastX = x;
                    lastY = y;
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                touched = false;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        hour++;
        if(energy > 0) {
            energy -= minusEnerGy;
        } else {
            energy = 0;
            energyBar.remove();
            if(infoMeat != null && infoMeat.getStage() != null){
                infoMeat.remove();
            }
            remove();
        }
        energyBar.setSize(getWidth() * energy/100, 4);
        energyBar.setPosition(getX(), getY() + getHeight() + 4);
        if(energy < 50){
            energyBar.setColor(Color.YELLOW);
            if(energy < 30) {
                energyBar.setColor(Color.RED);
            }
        }
        if(ill){
            setColor(0,1, 0, 1);
            timeForIll += delta;
            if(timeForIll > timeforIllMax){
                energyBar.remove();
                remove();
            }
        } else {
            setColor(1,1, 1, 1);
            if(age > 3 && hour % (60*2) == 0){
                if(MathUtils.random(1, 50) < 3){
                    ill = true;
                }
            }
        }
        if(getStage() != null && energyBar.getStage() == null){
            getStage().addActor(energyBar);
        }
    }

    public void feed(){
        GameScreen.complete += 1;
        if (energy < 100) {
            switch (Master.type){
                case PUMKIN -> {
                    if(GameState.seedpu > 0){
                        GameState.seedpu -= 1;
                        energy += 50;
                    }
                }
                case CAROT -> {
                    if(GameState.seedc > 0) {
                        GameState.seedc -= 1;
                        energy += 20;
                    }
                }
                case POTATO -> {
                    if(GameState.seedp > 0) {
                        GameState.seedp -= 1;
                        energy += 10;
                    }
                }
                case TOMATO -> {
                    if(GameState.seedt > 0) {
                        GameState.seedt -= 1;
                        energy += 10;
                    }
                }
                case BEAN -> {
                    if(GameState.seedb > 0) {
                        GameState.seedb -= 1;
                        energy += 10;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String info = "";
        switch (name){
            case CHICKEN -> info = "Gà, nuôi đẻ trứng \n ";
            case PIG -> info = "Lợn, nuôi lấy thịt \n ";
            case COW -> info = "Bò, nuôi để vắt sữa! \n ";
        }
        if(energy > 50){
            info += "Chưa cần ăn vì đang no. ";
        } else {
            info += "Đang đói, cần cho ăn. ";
        }

        if(ill){
            info += "Trạng thái: ốm, cần tiêm thuốc";
        } else {
            info += "Trạng thái: khỏe mạnh";
        }

        return info;
    }
}
