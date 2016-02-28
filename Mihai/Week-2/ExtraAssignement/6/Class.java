/**
 * Created by Mihai on 27.02.2016.
 */
public class Class {
    static void start(Engine e){
        e.stopEngine();
    }
    static void breaks(Breaks e){
        e.pushBreak();
    }
    static void turnOn(Lights e){
        e.lightsOff();
    }
    static void traveling(Car e){
        e.travel();
    }
    public static void main(String[] args){
        Traveler traveler=new Traveler("Cineva");
        start(traveler);
        breaks(traveler);
        turnOn(traveler);
        traveling(traveler);
    }
}
