/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerpatternsample.display;

import java.util.Observable;
import java.util.Observer;
import observerpatternsample.subject.WeatherData;

/**
 *
 * @author Administrator
 */
public class StaticsDisplay implements DisplayElement, Observer {

    private float temp = 0, humidity = 0, pressure = 0;
    Observable observable;

    public StaticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;

            if (weatherData.getTemp() > this.temp) {
                this.temp = weatherData.getTemp();
            }
            if (weatherData.getHumidity() > this.humidity) {
                this.humidity = weatherData.getHumidity();
            }
            if (weatherData.getPressure() > this.pressure) {
                this.pressure = weatherData.getPressure();
            }
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("------------StaticsDisplay-----------");
        System.out.println("Max temp: " + temp);
        System.out.println("Max humidity: " + humidity);
        System.out.println("Max pressure: " + pressure);
    }

}
