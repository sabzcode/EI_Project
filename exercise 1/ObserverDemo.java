import java.util.*;

interface Observer {
    void update(int temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer obs) { observers.add(obs); }
    public void removeObserver(Observer obs) { observers.remove(obs); }

    public void setTemperature(int temp) {
        System.out.println("\n[WeatherStation] Temperature updated to " + temp + "°C");
        this.temperature = temp;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer obs : observers) { obs.update(temperature); }
    }
}

class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("[PhoneDisplay] Temperature now " + temperature + "°C");
    }
}

class TVDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("[TVDisplay] Temperature now " + temperature + "°C");
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.addObserver(new TVDisplay());

        station.setTemperature(25);
        station.setTemperature(30);
    }
}