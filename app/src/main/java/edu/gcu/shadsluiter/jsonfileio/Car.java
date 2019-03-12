package edu.gcu.shadsluiter.jsonfileio;

public class Car {

    int year;

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", make='" + make + '\'' +
                '}';
    }

    public Car(int year, String make) {
        this.year = year;
        this.make = make;
    }

    public Car() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    String make;
}
