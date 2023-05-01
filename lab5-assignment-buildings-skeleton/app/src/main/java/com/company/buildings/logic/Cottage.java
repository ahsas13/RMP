package com.company.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage extends House { //Объявление класса Cottage, который наследуется от класса House.
    public int dimension;
    private boolean mSecondFloor;
    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth);//Вызов конструктора суперкласса House с параметрами
    }
    public Cottage( int dimension, int lotLength, int lotWidth, String owner, boolean mSecondFloor) {
        super(dimension, dimension, lotLength, lotWidth, owner);//Вызов конструктора суперкласса House с параметрами
        this.mSecondFloor = mSecondFloor;
    }
    public boolean hasSecondFloor(){
        return mSecondFloor;
    }
    @Override
    public String toString() {
        String area = "";
        String pool = "";
        String owner = "n/a";
        String stories = "; is a cottage";
        if (hasSecondFloor()){
            stories = "; is a two story cottage";
        }

        return super.toString()+stories;
    }
    //Переопределение метода toString, который возвращает строку с информацией
    // о владельце, наличии бассейна, площади и количестве этажей коттеджа
}

