package edu.gcu.shadsluiter.jsonfileio;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> carList = new ArrayList<Car>();


    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    @Override
    public String toString() {
        return "CarList{" +
                "carList=" + carList +
                '}';
    }

    public CarList() {
//
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
