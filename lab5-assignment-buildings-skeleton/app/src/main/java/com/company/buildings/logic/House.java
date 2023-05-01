package com.company.buildings.logic;

import java.util.Objects;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building { //Объявление класса House, который наследуется от класса Building
    private String mOwner;
    private boolean mPool;
    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);//Вызов конструктора суперкласса Building с параметрами
        this.mOwner = owner;
        this.mPool = pool;
    }
    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        super(length, width, lotLength, lotWidth);//Вызов конструктора суперкласса Building с параметрами
        this.mOwner = owner;
    }
    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);//Вызов конструктора суперкласса Building с параметрами
    }
    public String getOwner() {
        return mOwner;
    }
    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }
    public boolean hasPool() {
        return mPool;
    }
    public void setPool(boolean mPool) {
        this.mPool = mPool;
    }
    @Override
    public String toString() {
        String area = "";
        String pool = "";
        String owner = "n/a";
        if (hasArea()){
            area = "; has a big open space";
        }
        if (hasPool()){
            pool = "; has a pool";
        }
        if (!getOwner().equals("")){
            owner = getOwner();
        }
        return "Owner: " + owner + pool+ area;
    }//Переопределение метода toString, который возвращает строку с информацией об объекте класса House
    @Override
    public boolean equals(Object o) {
        House house = (House) o;
        if ((this.getLength()*this.getWidth()) == (house.getLength()* house.getWidth()) && this.hasPool() == house.hasPool()){
            return true;
        }
        else {
            return false;
        }
    } //Переопределение метода equals, который сравнивает объекты класса House по их площади и наличию бассейна.

    @Override
    public int hashCode() {
        return Objects.hash(mOwner, mPool);
    }//Переопределение метода hashCode, который возвращает хэш-код объекта класса House.
    public boolean hasArea(){
        if (calcBuildingArea()<calcLotArea()){
            return true;
        }
        else{
            return false;
        }
    }//Объявление метода hasArea, который возвращает true, если площадь здания меньше площади участка, и false в противном случае.
}
