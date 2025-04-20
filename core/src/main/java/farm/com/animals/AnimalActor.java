package farm.com.animals;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.EnergyBar;
import farm.com.MyActor;
import farm.com.ShowInfo;

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
    ShowInfo infoMilk;

    EnergyBar energyBar;
    AnimalActor(float x, float y, Stage s) {
        super(x, y, s);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(energy > 0) {
            energy -= minusEnerGy;
        } else {
            energy = 0;
            energyBar.remove();
            if(infoMeat.getStage() != null){
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
    }

}
