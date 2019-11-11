package org.sonatype.mavenbook.ch07;

import lombok.Data;

@Data
public class WeatherService {

    private YahooRetriever yahooRetriever;
    private YahooParser yahooParser;

    public Weather retrieveForecast(String location) throws Exception {
        String data = yahooRetriever.retrieve(location);
        Weather weather = yahooParser.parse(data);
        return weather;
    }
}
