package farm.com.animals;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.EnergyBar;
import farm.com.MyActor;
import farm.com.ShowInfo;
import farm.com.screens.GameScreen;

public class AnimalActor extends MyActor {

    farm.com.enums.AnimalNames name;
    float energy = 100;
    float minusEnerGy = 0;
    float cost = 100;
    float meat = 0;
    int milk = 1;
    float sellingPrice = 100;
    public int age;

    ShowInfo infoMeat;
    EnergyBar energyBar;

    boolean ill = false;
    float timeForIll = 0;
    float timeforIllMax = 5;
    int hour = 0;
    AnimalActor(float x, float y, Stage s) {
        super(x, y, s);
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

}
