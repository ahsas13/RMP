package com.company.gate.logic;
/**
 * This file defines the Gate class.
 */
public class Gate {
    public static final int OUT = -1;
    public static final int IN = 1;
    public static final int CLOSED = 0;
    private int mSwing;
    public int getSwingDirection() {
        return mSwing;
    }
    public boolean setSwing(int mSwing) {
        if (mSwing >= -1 && mSwing <= 1) {//проверка, что значение параметра "mSwing" находится в диапазоне от "-1" до "1"
            this.mSwing = mSwing; //установка значения параметра "mSwing" в поле "mSwing".
            return true;
        } else {
            return false;
        }
    }
    public boolean open(int direction) { //объявление метода "open()" с одним параметром типа "int", который открывает ворота в заданном направлении
        if (direction == IN || direction == OUT) { //проверка, что значение параметра "direction" равно "IN" или "OUT".
            setSwing(direction); // вызов метода "setSwing()" с параметром "direction".
            return true; // возврат  "true", если ворота были открыты в заданном направлении.
        }
        return false;  //возврат  "false", если ворота не были открыты в заданном направлении.
    }
        public void close() { //объявление метода "close()", который закрывает ворота.
        setSwing(CLOSED); //вызов метода "setSwing()" с параметром "CLOSED".
    }
    public int thru(int count) {//объявление метода "thru()" который возвращает количество прошедших через ворота.
        return (getSwingDirection() == OUT) ? -count : (getSwingDirection() == IN) ? count : 0;
//возврат значения, которое зависит от направления открытия ворот и количества прошедших
    }
    @Override
     public String toString() {//объявление метода "toString()", который возвращает строковое представление объекта.
        switch (getSwingDirection()) {// оператор выбора, который выбирает один из нескольких вариантов в зависимости от значения, возвращаемого методом "getSwingDirection()"
            case CLOSED:// Закрытые ворота
                return "This gate is closed";
            case IN:// ворота, установлены в положение IN
                return "This gate is open and swings to enter the pen only";
            case OUT:// ворота, установлены в положение OUT
                return "This gate is open and swings to exit the pen only";
            default: // выполняется, если значение не соответствует ни одному из вариантов
                return "This gate has an invalid swing direction";
        }
    }
}