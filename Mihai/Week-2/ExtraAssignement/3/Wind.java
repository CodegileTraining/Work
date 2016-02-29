public class Wind implements Instrument{


    @Override
    public void play() {
        System.out.println("WIND");
    }

    @Override
    public String what() {
        return this.getClass().toString();
    }

    @Override
    public void adjust() {
        System.out.println("Adjust Wind");
    }
}
