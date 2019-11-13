package org.sonatype.mavenbook.ch07;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

    private WeatherService weatherService;
    private WeatherDAO weatherDAO;
    private LocationDAO locationDAO;

    public static void main(String[] args) throws Exception {
        // Configure Log4J
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource(
                "log4j.properties"));

        // Read the city name from the Command-line (if none supplied, use bellevue,wa)
        String city = "bellevue,wa";
        try {
            city = args[0];
        } catch (Exception e) {
        }

        String woeid = "2362031";
        try {
            woeid = args[1];
        } catch (Exception e) {
        }

        // Read the Operation from the Command-line (if none supplied, use weather)
        String operation = "weather";
        try {
            operation = args[2];
        } catch (Exception e) {
        }

        log.info("city = {}, woeid = {}, operation = {}", city, woeid, operation);

        // Start the program
        Main main = new Main(city, woeid);

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"classpath:applicationContext-weather.xml",
                                "classpath:applicationContext-persist.xml"});
        main.weatherService = (WeatherService) context.getBean("weatherService");
        main.locationDAO = (LocationDAO) context.getBean("locationDAO");
        main.weatherDAO = (WeatherDAO) context.getBean("weatherDAO");
        if (operation.equals("weather")) {
            main.getWeather();
        } else {
            main.getHistory();
        }
    }

    private String city;
    private String woeid;

    public Main(String city, String woeid) {
        this.city = city;
        this.woeid = woeid;
    }

    public void getWeather() throws Exception {
        Weather weather = weatherService.retrieveForecast(city);
        weatherDAO.save(weather);
        System.out.print(new WeatherFormatter().formatWeather(weather));
    }

    public void getHistory() throws Exception {
        Location location = locationDAO.findByWoeid(woeid);
        List<Weather> weathers = weatherDAO.recentForLocation(location);
        System.out.print(new WeatherFormatter().formatHistory(location, weathers));
    }
}
