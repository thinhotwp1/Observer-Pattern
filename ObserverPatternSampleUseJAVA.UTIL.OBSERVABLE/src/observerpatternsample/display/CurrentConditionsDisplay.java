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
public class CurrentConditionsDisplay implements DisplayElement, Observer{
    
    private float temp = 0, humidity = 0;
    Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temp=weatherData.getTemp();
            this.humidity=weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("------------CurrentDisplay-----------");
        System.out.println("temp: "+temp+"C humidity: "+humidity+"%");
    }
    
}
