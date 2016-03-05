public class Percussion implements Instrument{

    @Override
    public void play() {
        System.out.println("Percusion");
    }

    @Override
    public String what() {
        return this.getClass().toString();
    }

    @Override
    public void adjust() {
        System.out.println("Adjust Pecusion");
    }
}
