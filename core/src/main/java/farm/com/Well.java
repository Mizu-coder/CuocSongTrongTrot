package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Well extends MyActor{
    Master game;
    Well(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = Utils.getRegion(16*8,16*7, 16,16*2);
        setSize(textureRegion.getRegionWidth()*3, textureRegion.getRegionHeight()*4);
        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                if(game.type ==1){
                    game.water = 1;
                }
                if(game.type ==2){
                    game.water = 2;
                }
                if(game.type ==3){
                    game.water = 3;
                }
                if(game.type ==4){
                    game.water = 4;
                }
                if(game.type ==5){
                    game.water = 5;
                }

            }
        });
    }
}
