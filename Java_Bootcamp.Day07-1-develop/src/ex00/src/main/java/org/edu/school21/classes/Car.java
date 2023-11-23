package org.edu.school21.classes;

import java.util.StringJoiner;

public class Car {
    private String model;
    private String madeCountry;
    private int madeYear;

    public Car() {
        this.model = "Default model";
        this.madeCountry = "Japan";
        this.madeYear = 2000;
    }

    public Car(String model, String madeCountry, int madeYear) {
        this.model = model;
        this.madeCountry = madeCountry;
        this.madeYear = madeYear;
    }

    public int ageOfCar(int thisYear) {
        return thisYear - madeYear;
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("model='" + this.model + "'")
                .add("country='" + this.madeCountry + "'")
                .add("year='" + this.madeYear + "'")
                .toString();
    }
}
