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
public class CurrentConditionsDisplay implements DisplayElement, Observer{
    
    private float temp = 0, humidity = 0;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("------------CurrentDisplay-----------");
        System.out.println("temp: "+temp+"C humidity: "+humidity+"%");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
    
}
