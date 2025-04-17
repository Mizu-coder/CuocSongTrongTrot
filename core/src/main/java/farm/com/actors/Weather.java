package farm.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.screens.Master;
import farm.com.MyActor;
import farm.com.enums.WeatherType;

public class Weather extends MyActor {
    public WeatherType weatherType = WeatherType.RAIN;
    TextureRegion textureRegionRain;
    TextureRegion textureRegionSunny;
    Master game;
    public Weather(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegionRain = new TextureRegion(new Texture("rain.png"));
        textureRegionSunny = new TextureRegion(new Texture("sunny.jpg"));
        textureRegion = textureRegionRain;
        weatherType = WeatherType.values()[MathUtils.random(0, WeatherType.values().length -1)];
        ranDomWeatherType();

    }

    public void ranDomWeatherType() {
        weatherType = WeatherType.values()[MathUtils.random(0, WeatherType.values().length -1)];
        switch (weatherType){
            case RAIN -> {
                textureRegion = textureRegionRain;
                game.rai += 1;
                game.sun = 0;
            }
            case SUNNY -> {
                textureRegion = textureRegionSunny;
                game.sun += 1;
                game.rai = 0;
            }

            default -> textureRegion = textureRegionRain;
        }
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}
