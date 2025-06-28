package farm.com;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import farm.com.animals.Chicken;
import farm.com.animals.Cow;
import farm.com.animals.Pig;
import farm.com.enums.ChooseType;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;
import farm.com.seeds.Plants;
import farm.com.utils.GameStateForSave;

public class GameState {
    public static int money = 0000;
    public static int milkTotal = 0;
    public static int egg = 0;
    public static int totalPork = 0;
    public static int soKimTiem = 2;

    public static int seedc = 5;
    public static int seedb = 5;
    public static int seedp = 5;
    public static int seedt = 5;
    public static int seedpu = 5;

    public static void loadData(Master game, GameStateForSave gameStateForSave) {
        money = gameStateForSave.money;
        milkTotal = gameStateForSave.milkTotal;
        egg = gameStateForSave.egg;
        totalPork = gameStateForSave.totalPork;
        soKimTiem = gameStateForSave.soKimTiem;
        seedc = gameStateForSave.seedc;
        seedb = gameStateForSave.seedb;
        seedp = gameStateForSave.seedp;
        seedt = gameStateForSave.seedt;
        seedpu = gameStateForSave.seedpu;

        for (Vector3 v: gameStateForSave.pumkins) {
            Master.type = ChooseType.PUMKIN;
            GameScreen.listPlants.add(new Plants(v.x, v.y, null, game, v.z));
        }
        for (Vector3 v: gameStateForSave.carrots) {
            Master.type = ChooseType.CAROT;
            GameScreen.listPlants.add(new Plants(v.x, v.y, null, game, v.z));
        }
        for (Vector3 v: gameStateForSave.tomatos) {
            Master.type = ChooseType.TOMATO;
            GameScreen.listPlants.add(new Plants(v.x, v.y, null, game, v.z));
        }
        for (Vector3 v: gameStateForSave.potatos) {
            Master.type = ChooseType.POTATO;
            GameScreen.listPlants.add(new Plants(v.x, v.y, null, game, v.z));
        }
        for (Vector3 v: gameStateForSave.beans) {
            Master.type = ChooseType.BEAN;
            GameScreen.listPlants.add(new Plants(v.x, v.y, null, game, v.z));
        }

        for (Vector2 v: gameStateForSave.cows) {
            GameScreen.cows.add(new Cow(v.x, v.y, null));
        }
        for (Vector2 v: gameStateForSave.pigs) {
            GameScreen.pigs.add(new Pig(v.x, v.y, null));
        }
        for (Vector2 v: gameStateForSave.chickens) {
            GameScreen.chickens.add(new Chicken(v.x, v.y, null));
        }
    }
}
