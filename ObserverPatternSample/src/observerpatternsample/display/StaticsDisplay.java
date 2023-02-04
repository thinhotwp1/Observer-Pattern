/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerpatternsample.display;

import observerpatternsample.observer.Observer;
import observerpatternsample.subject.Subject;

/**
 *
 * @author Administrator
 */
public class StaticsDisplay implements DisplayElement, Observer {

    private float temp = 0, humidity = 0, pressure = 0;
    private Subject weatherData;

    public StaticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    

    @Override
    public void display() {
        System.out.println("------------StaticsDisplay-----------");
        System.out.println("Max temp: " + temp);
        System.out.println("Max humidity: " + humidity);
        System.out.println("Max pressure: " + pressure);

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        if (temp > this.temp) {
            this.temp = temp;
        }
        if (humidity > this.humidity) {
            this.humidity = humidity;
        }
        if (pressure > this.pressure) {
            this.pressure = pressure;
        }
        display();
    }

}
