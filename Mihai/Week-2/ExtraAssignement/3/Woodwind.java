public class Woodwind extends Wind{

    public void play(){
        System.out.println("Play Woodwind");
    }
    public String what(){
        return this.getClass().toString();
    }

}
