import java.util.Scanner;

/**
 * Created by Mihai on 27.02.2016.
 */
public class Traveler extends Hooman implements Car {
    public Traveler(String name) {
        super(name);
    }

    @Override
    public void travel() {
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() == 1) {
            this.startEngine();
            this.lightsOn();
            this.releasBreak();
            System.out.println(this.getName()+ " is traveling");
        }
        else
        {
            this.pushBreak();
            this.stopEngine();
            this.lightsOff();
            System.out.println(this.getName()+ " has stopped");
        }
    }

    @Override
    public void pushBreak() {
        System.out.println("Break is pushed");
    }

    @Override
    public void releasBreak() {
        System.out.println("Break is released");
    }

    @Override
    public void startEngine() {
        System.out.println("Engine is running");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine is stopped");
    }

    @Override
    public void lightsOn() {
        System.out.println("Lights are on");
    }

    @Override
    public void lightsOff() {
        System.out.println("Lights are off");
    }
}
