package timer;

/**
 * Created by Mirco Baalmans on 9/12/2017.
 */

public class Timer {

    private long startTime;
    private long endTime;
    private long result;
    private boolean loop;
    private static final long second = 1000;



    public int setTimer(long milliseconds, boolean loop){
        startTime = System.currentTimeMillis();
        this.loop = loop;
        long countDown = milliseconds;

        while(this.loop){
            endTime = System.currentTimeMillis();
            if(countDown <= 0){

                return 1;
            }
            result = endTime - startTime;

            if(result == second){
                countDown -= second;
                startTime = System.currentTimeMillis();
                result = 0;
            }
        }
        return 0;
    }

    public void startStopwatch(){
        System.out.println("Starting stopwatch");
        startTime = System.currentTimeMillis();
    }

    public void stopStopwatch(){
        System.out.println("Stopping stopwatch");
        endTime = System.currentTimeMillis();
    }

    public void stopTimer(){
        loop = false;
    }
    public void printResultStopwatch(String unit){
        endTime = System.currentTimeMillis();

        result = (endTime - startTime);

        switch(unit){
            case "minutes" :
                System.out.println(toMinutes(result) + " " + unit);
                break;
            case "seconds" :
                System.out.println(toSeconds(result) + " " + unit);
                break;
            case "milliseconds":
                System.out.println(result + " " + unit);
                break;
        }
    }


    private long toMinutes(long t){
        return Math.round(toSeconds(t) / 60);
    }

    private long toSeconds(long t){
        return t / 1000;
    }


}
