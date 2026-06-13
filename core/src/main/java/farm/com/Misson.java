package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.animals.Chicken;
import farm.com.animals.Cow;
import farm.com.animals.Pig;
import farm.com.enums.NV;
import farm.com.inshop.SellButton;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;

public class Misson extends MyActor{
    NV nv = NV.CAY;
    Master game;
    GameScreen gameScreen;
    SellButton sellButton;
    public Misson(float x, float y, Stage s,Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = new TextureRegion(new Texture("misson.png"));
        sellButton = new SellButton(1000,1000,s,game);
        setSize(84, 94);
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                GameScreen.go = true;
            }
        });
    }

    public void giaoNV(){
        nv = NV.values()[MathUtils.random(0, NV.values().length - 1)];
    }
    public void choNV(){
        switch (nv){
            case NOTHING -> {
                gameScreen.layout.setText(game.font, " Không có nhiệm vụ");
                game.font.draw(game.batch, gameScreen.layout,gameScreen.khung.getX()+ 650, gameScreen.khung.getY()+ 750);
            }
            case DONGVAT -> {
                gameScreen.layout.setText(game.font, " Cho động vật ăn 5 lần (con vật nào cũng được không bắt buộc 1 loài) " + gameScreen.complete +" /5");
                game.font.draw(game.batch, gameScreen.layout,gameScreen.khung.getX()+ 590, gameScreen.khung.getY()+ 750);
                gameScreen.layout.setText(game.font, "Phần thưởng 1 con vật bất kì");
                game.font.draw(game.batch,gameScreen.layout,gameScreen.khung.getX()+ 590, gameScreen.khung.getY()+ 710);
            }
            case BAN -> {
                gameScreen.layout.setText(game.font,"Bán 1 thứ bất kì" + gameScreen.complete +" /1");
                game.font.draw(game.batch,gameScreen.layout,gameScreen.khung.getX()+ 650, gameScreen.khung.getY()+ 750);
                gameScreen.layout.setText(game.font,"Phần thưởng 400 xu");
                game.font.draw(game.batch, gameScreen.layout,gameScreen.khung.getX()+ 650, gameScreen.khung.getY()+ 710);
            }
            case CAY -> {
                gameScreen.layout.setText(game.font, "Tưới và thu hoạch 5 cây" + gameScreen.complete +" /5");
                game.font.draw(game.batch, gameScreen.layout,gameScreen.khung.getX()+ 720, gameScreen.khung.getY()+ 750);
                gameScreen.layout.setText(game.font,"Phần thưởng 5 hạt giống ngẫu nhiên");
                game.font.draw(game.batch, gameScreen.layout,gameScreen.khung.getX()+ 720, gameScreen.khung.getY()+ 710);
            }
        }
    }
    public void thuongDV(){
        switch (nv){
            case DONGVAT -> {
                GameScreen.complete += 1;
            }
        };
        if(GameScreen.complete == 5){
            switch (nv){
                case DONGVAT -> {
                    if (Master.sohieu == 1){
                        GameScreen.pigs.add(new Pig(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), GameScreen.stage ));
                    }
                    if (Master.sohieu == 2){
                        GameScreen.cows.add(new Cow(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), GameScreen.stage));
                    }
                    if (Master.sohieu == 3){
                        GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), GameScreen.stage));
                    }
                }
            }
        }


    }
    public void thuongCay(){
        if(GameScreen.complete == 5){
            switch (nv){
                case CAY -> {
                    if (Master.sohat == 1){
                        GameState.seedpu += 5;
                    }
                    if (Master.sohat == 2){
                        GameState.seedc += 5;
                    }
                    if (Master.sohat == 3){
                        GameState.seedp += 5;
                    }
                    if (Master.sohat == 4){
                        GameState.seedt += 5;
                    }
                    if (Master.sohat == 5){
                        GameState.seedb += 5;

                    }
                }
            }

        }
    }
}
