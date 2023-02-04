/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package observerpatternsample;

import java.util.Observer;
import observerpatternsample.display.CurrentConditionsDisplay;
import observerpatternsample.display.ForecastDisplay;
import observerpatternsample.display.StaticsDisplay;
import observerpatternsample.subject.WeatherData;

/**
 *
 * @author Administrator
 */
public class ObserverPatternSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WeatherData weatherData = new WeatherData();
        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);
        Observer staticsDisplay = new StaticsDisplay(weatherData);
        
        
        System.out.println("================ START ================");
        System.out.println("FIRST TIME");
        weatherData.setMeasurements(25, 50, 5);
        System.out.println("AFTER UPDATE");
        weatherData.deleteObserver(forecastDisplay); // hủy đăng kí của forecastDisplay
        weatherData.setMeasurements(40, 40, 10);
        System.out.println("================ END ================");
    }
    
}
