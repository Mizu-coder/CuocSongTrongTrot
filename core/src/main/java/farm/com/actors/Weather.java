package farm.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.enums.WeatherType;

public class Weather extends MyActor {
    public WeatherType weatherType = WeatherType.RAIN;
    TextureRegion textureRegionRain;
    TextureRegion textureRegionSunny;
    public Weather(float x, float y, Stage s) {
        super(x, y, s);

        textureRegionRain = new TextureRegion(new Texture("rain.png"));
        textureRegionSunny = new TextureRegion(new Texture("sunny.jpg"));
        textureRegion = textureRegionRain;
        weatherType = WeatherType.values()[MathUtils.random(0, WeatherType.values().length -1)];
        ranDomWeatherType();

    }

    public void ranDomWeatherType(){
        weatherType = WeatherType.values()[MathUtils.random(0, WeatherType.values().length -1)];
        switch (weatherType){
            case RAIN -> textureRegion = textureRegionRain;
            case SUNNY -> textureRegion = textureRegionSunny;
            default -> textureRegion = textureRegionRain;
        }
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}
