package Experiment4.Fruit;

import java.util.Objects;

public class FruitEntity {
    private String name;
    private int id;
    private double price;
    private String measurement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
    public FruitEntity(){
        super();
    }
    public FruitEntity(String name,int id,double price,String measurement){
        super();
        this.name = name;
        this.id = id;
        this.price = price;
        this.measurement = measurement;
    }

    public boolean equals(Object obj){
        FruitEntity fruitEntity = (FruitEntity) obj;
        if (fruitEntity.getId() == id){
            return true;
        }
        return false;
    }
}
