package com.design.observer.pull;

public class ForecastDisplay implements Observer, DisplayElement{
   private float currentPressure = 29.2f;
   private float lastPressure;
   private WeatherData weatherData;

   public ForecastDisplay(WeatherData weatherData) {
      this.weatherData = weatherData;
      weatherData.registerObserver(this);
   }

   @Override
   public void display() {
      System.out.println("현재 기압: " + currentPressure + ", 이전 기압:  " + lastPressure);
   }

   @Override
   public void update() {
      lastPressure = currentPressure;
      currentPressure = weatherData.getPressure();
      display();
   }
}
