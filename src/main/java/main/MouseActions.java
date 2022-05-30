package main;

public class MouseActions {
    long timer;
    int count=0;
   static long timerMill;
    public static boolean TwoTimeClicked(int CounterClick){
        boolean execute= false;
        if(CounterClick == 1){
            timerMill = System.currentTimeMillis()+1000;
        }else if(CounterClick == 2 && timerMill>=System.currentTimeMillis()){
            execute = true;
        }
        return execute;
    }
    public boolean TwoTimeClicked(){
        if(count<1){
            count++;
            timer = System.currentTimeMillis();
        } else if (timer>= System.currentTimeMillis()-10000) {
            count=0;
            return true;
        }else {
            timer = System.currentTimeMillis();
            count=0;
        }
        return false;
    }



}
