package com.company.buildings.logic;

import java.util.Objects;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {//Объявление класса Office, который наследуется от класса Building
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;
    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth) {
        super(mLength, mWidth, mLotLength, mLotWidth);//Вызов конструктора суперкласса Building с параметрами
        this.mParkingSpaces = 0;
        this.mBusinessName = null;
        sTotalOffices += 1;
    }
    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth, String mBusinessName) {
        this(mLength, mWidth, mLotLength, mLotWidth);
        this.mBusinessName = mBusinessName;
    }
    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth, String mBusinessName, int mParkingSpaces) {
        this(mLength, mWidth, mLotLength, mLotWidth, mBusinessName);
        this.mParkingSpaces = mParkingSpaces;
    }
    public String getBusinessName() {
        return mBusinessName;
    }
    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }
    public int getParkingSpaces() {
        return mParkingSpaces;
    }
    public void setParkingSpaces(int mParkingSpaces) {
        this.mParkingSpaces = mParkingSpaces;
    }
    @Override
    public String toString() {//Переопределение метода toString, который возвращает строку с информацией об объекте класса Office.
        String occup = "unoccupied";
        String parking = "";
        if (getParkingSpaces()>0){
            parking = "; has "+getParkingSpaces()+" parking spaces"; //Если значение переменной mParkingSpaces больше 0,
            // то присвоить переменной parking строку с информацией о количестве парковочных мест.
        }
        if (!"".equals(getBusinessName()) && getBusinessName() != null){//Если значение переменной mBusinessName
            // не равно "" и не равно null, то присвоить переменной occup значение переменной mBusinessName.
            occup = getBusinessName();
        }
        return "Business: " + occup+parking+" (total offices: "+sTotalOffices+")";//Возврат строки с информацией об объекте класса Office.
    }
    @Override
    public boolean equals(Object o) {//Переопределение метода equals, который сравнивает объекты класса Office
        // по их площади и количеству парковочных мест.
        Office office = (Office) o;
        if ((this.getLength()*this.getWidth()) == (office.getLength()* office.getWidth()) && this.getParkingSpaces() == office.getParkingSpaces()){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(mBusinessName, mParkingSpaces);
    }//Переопределение метода hashCode, который возвращает хэш-код объекта класса Office.
}
