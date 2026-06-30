package farm.com.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import farm.com.GameState;
import farm.com.animals.Chicken;
import farm.com.animals.Cow;
import farm.com.animals.Pig;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;
import farm.com.seeds.Plants;

public class GameStateForSave {
    public  int money = 00000;
    public  int milkTotal = 0;
    public  int egg = 0;
    public  int totalPork = 0;
    public  int soKimTiem = 2;

    public  int seedc = 5;
    public  int seedb = 5;
    public  int seedp = 5;
    public  int seedt = 5;
    public  int seedpu = 5;
    public int seedpa = 0;

    public Array<Vector3> pumkins = new Array<>();
    public Array<Vector3> carrots = new Array<>();
    public Array<Vector3> tomatos = new Array<>();
    public Array<Vector3> potatos = new Array<>();
    public Array<Vector3> beans = new Array<>();
    public Array<Vector3> paddies = new Array<>();
    public Array<Vector2> chickens = new Array<>();
    public Array<Vector2> pigs = new Array<>();
    public Array<Vector2> cows = new Array<>();


    public GameStateForSave(){}

    public GameStateForSave(Master game) {
        this.money = GameState.money;
        this.milkTotal = GameState.milkTotal;
        this.egg = GameState.egg;
        this.totalPork = GameState.totalPork;
        this.soKimTiem = GameState.soKimTiem;
        this.seedc = GameState.seedc;
        this.seedb = GameState.seedb;
        this.seedp = GameState.seedp;
        this.seedt = GameState.seedt;
        this.seedpu = GameState.seedpu;
        this.seedpa = GameState.seedpa;

        for (Plants p: game.gameScreen.listPlants) {
            switch (p.plantType){
                case PUMKIN -> {
                    pumkins.add(new Vector3(p.getX(), p.getY(), p.time));
                }
                case CARROT -> {
                    carrots.add(new Vector3(p.getX(), p.getY(), p.time));
                }
                case TOMATO -> {
                    tomatos.add(new Vector3(p.getX(), p.getY(), p.time));
                }
                case POTATO -> {
                    potatos.add(new Vector3(p.getX(), p.getY(), p.time));
                }
                case BEAN -> {
                    beans.add(new Vector3(p.getX(), p.getY(), p.time));
                }
                case PADDY -> {
                    paddies.add(new Vector3(p.getX(),p.getY(),p.time));
                }
            }

        }

        for (Cow c: GameScreen.cows) {
            cows.add(new Vector2(c.getX(), c.getY()));
        }
        for (Chicken c: GameScreen.chickens) {
            chickens.add(new Vector2(c.getX(), c.getY()));
        }

        for (Pig c: GameScreen.pigs) {
            pigs.add(new Vector2(c.getX(), c.getY()));
        }

    }
}
