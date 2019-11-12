package org.sonatype.mavenbook.web.ch07;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.sonatype.mavenbook.ch07.Weather;
import org.sonatype.mavenbook.ch07.WeatherDAO;
import org.sonatype.mavenbook.ch07.WeatherService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Slf4j
public class WeatherController implements Controller {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	private WeatherService weatherService;
	private WeatherDAO weatherDAO;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.error("##################entering WeatherController.");

		String name = request.getParameter("name");
//		String name = "bellevue,wa";
		Weather weather = weatherService.retrieveForecast(name);
		log.error("################get result: {}, {}", weather.getLocation().getCity(), weather.getAtmosphere().getHumidity());
		weatherDAO.save(weather);
		return new ModelAndView("weather", "weather", weather);
	}

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	public WeatherDAO getWeatherDAO() {
		return weatherDAO;
	}

	public void setWeatherDAO(WeatherDAO weatherDAO) {
		this.weatherDAO = weatherDAO;
	}
}