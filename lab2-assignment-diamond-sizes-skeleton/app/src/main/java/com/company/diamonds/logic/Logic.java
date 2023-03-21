package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        String first = "+";
        int dev = 3;
        String slashStyle = "=";
        for (int i = 0; i<size*2;i++){
            first = first + "-";
        }
        first=first+"+";
        mOut.println(first);
        for (int i = 1;i<size*2;i++){
            int sizeOfSpaces = size - i;
            int sizeOfSlashes = size - sizeOfSpaces - 1;
            int sizeOfSpacesReverse = i - size;
            if (size == 1){
                mOut.println("|<>|");
            }
            else{
                if (i == size){
                    mOut.print("|<");
                    for (int i2 = 0;i2<sizeOfSlashes *2;i2++){
                        mOut.print(slashStyle);
                    }
                    mOut.println(">|");
                }
                else {
                    if (i<size){
                        mOut.print("|");
                        for (int i1 = 0; i1<sizeOfSpaces; i1++){
                            mOut.print(" ");
                        }
                        mOut.print("/");
                        for (int i2 = 0;i2<sizeOfSlashes *2;i2++){
                            mOut.print(slashStyle);
                        }
                        mOut.print("\\");
                        for (int i3 = 0; i3 <sizeOfSpaces; i3++){
                            mOut.print(" ");
                        }
                        mOut.println("|");
                    }
                    else {
                        int sizeOfSlashesReverse = i-dev;
                        dev = dev +2;
                        mOut.print("|");
                        for (int i1 = 0; i1<sizeOfSpacesReverse; i1++){
                            mOut.print(" ");
                        }
                        mOut.print("\\");
                        for (int i2 = 0;i2<sizeOfSlashesReverse *2;i2++){
                            mOut.print(slashStyle);
                        }
                        mOut.print("/");
                        for (int i3 = 0; i3 <sizeOfSpacesReverse; i3++){
                            mOut.print(" ");
                        }
                        mOut.println("|");
                    }
                }
            }
            if (slashStyle == "="){
                slashStyle = "-";
            }
            else {
                slashStyle = "=";
            }
        }
        mOut.println(first);
    }
}
