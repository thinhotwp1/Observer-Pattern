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
public class ForecastDisplay implements DisplayElement, Observer {

    private float temp = 0, humidity = 0, pressure = 0;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    

    @Override
    public void display() {
        System.out.println("------------ForecastDisplay-----------");
        if (this.temp > 35) {
            System.out.println("HOT !");
        }
        if (this.temp < 15) {
            System.out.println("COLD !");
        }
        if (this.temp < 35 && this.temp > 15) {
            System.out.println("NORMAL !");
        }
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        display();
    }

}
