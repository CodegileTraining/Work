public class Stringed implements Instrument{
    @Override
    public void play() {
        System.out.println("Playing Stringed");
    }

    @Override
    public String what() {
        return this.getClass().toString();

    }

    @Override
    public void adjust() {

        System.out.println("Adjust Stringed");

    }
}
