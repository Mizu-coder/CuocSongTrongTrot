package farm.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class AnimalActor extends MyActor{
    float energy = 100;
    float cost = 100;
    float sellingPrice = 100;
    AnimalActor(float x, float y, Stage s) {
        super(x, y, s);
    }
}
