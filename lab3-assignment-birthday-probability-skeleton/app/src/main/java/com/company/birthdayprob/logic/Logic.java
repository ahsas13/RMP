package com.company.birthdayprob.logic;

import java.util.Random;

import com.company.birthdayprob.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 *
 */
public class Logic 
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG =
        Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
    */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process...' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            mOut.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage");
        mOut.println("of times that two people share the same birthday is");
        mOut.println(String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {
        double counter = 0; //количество симуляций, в которых были два одинаковых дня рождения
        for (int i = 0; i < count; i++) {
            int[] Bdays = new int[365]; //создаем целочисленный массив `Bdays` размером 365, представляющий количество дней в году.
            Random rand = new Random(); //создаем новый "Случайный" объект "rnd"
            rand.setSeed(i +1); // устанавливаем его начальное значение в "i + 1`.
            //Установка начального значения гарантирует, что при каждом запуске программы с одними и теми же входными значениями генерируется одна и та же последовательность случайных чисел
            int[] ppls = new int[size]; //создаем целочисленный массив `ppls` размера `size`, представляющий количество людей в группе.
            for(int j = 0; j < size; j++) { //Для каждого человека генерируется случайное целое число от 0 до 364 (включительно)
                ppls[j] = rand.nextInt(365);//с использованием метода `nextInt` объекта `Random` `rnd` и сохраняется в массиве `ppls`.
            }
            for (int ppl : ppls) { //перебираем массив `ppls` и увеличивает соответствующий
                Bdays[ppl]++; //элемент массива `Bdays` для дня рождения каждого человека.
            }
            if (checkCoincidence(Bdays)) { //проверяем, есть ли какие-либо повторяющиеся дни рождения в массиве `Bdays`, вызывая метод `checkCoincidence`.
                counter++; // Если есть дубликаты, переменная `counter` увеличивается.
            }
        }
        double res = counter / count * 100;// вычисляем процент res с повторяющимися днями рождения
        // путем деления переменной `counter` на `count` и умножения на 100.
        if(res < 0.0) {
            res = 0.0;
        }
        if(res > 100.0) {
            res = 100.0; //рассчитанный % находится в диапазоне от 0 до 100
        }
        return res; //возвращаем рассчтанный процент
    }
    private boolean checkCoincidence(int[] Bdays) {
        for (int day : Bdays) {
            if (day > 1)
                return true;
            //метод `checkCoincidence`, принимает целочисленный массив `Bdays` в качестве аргумент
            //и возвращает логическое значение.
            // перебирает массив и возвращает `true`, если какой-либо
            // элемент больше 1, что указывает на повторяющийся день рождения.
        }
        return false;
    }
}
