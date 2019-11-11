package org.sonatype.mavenbook.ch07;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.Date;


public class YahooParser {
    private static Logger log = Logger.getLogger(YahooParser.class);

    public Weather parse(String result) throws Exception {
        log.info("Creating JSON Reader");
        JSONObject jo = new JSONObject(result);
        Weather weather = new Weather();
        weather.setId(new Date().getTime());

        Location location = new Location();
        location.setWoeid(String.valueOf(jo.getJSONObject("location").getInt("woeid")));
        location.setCity(jo.getJSONObject("location").getString("city"));
        location.setCountry(jo.getJSONObject("location").getString("country"));
        location.setRegion(jo.getJSONObject("location").getString("region"));
        weather.setLocation(location);

        Condition condition = new Condition();
        condition.setCode(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("condition").getInt("code")));
        condition.setDate(String.valueOf(jo.getJSONObject("current_observation").getInt("pubDate")));
        condition.setTemp(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("condition").getInt("temperature")));
        condition.setText(jo.getJSONObject("current_observation").getJSONObject("condition").getString("text"));
        condition.setWeather(weather);
        weather.setCondition(condition);

        Wind wind = new Wind();
        wind.setChill(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("wind").getInt("chill")));
        wind.setDirection(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("wind").getInt("direction")));
        wind.setSpeed(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("wind").getFloat("speed")));
        wind.setWeather(weather);
        weather.setWind(wind);

        Atmosphere atmosphere = new Atmosphere();
        atmosphere.setHumidity(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("atmosphere").getInt("humidity")));
        atmosphere.setPressure(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("atmosphere").getInt("pressure")));
        atmosphere.setRising(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("atmosphere").getInt("rising")));
        atmosphere.setVisibility(String.valueOf(jo.getJSONObject("current_observation").getJSONObject("atmosphere").getInt("visibility")));
        atmosphere.setWeather(weather);
        weather.setAtmosphere(atmosphere);

        weather.setDate(new Date());
        return weather;
    }
}
