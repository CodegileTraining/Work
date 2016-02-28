/**
 * Created by Mihai on 24.02.2016.
 */
interface Instrument {
    void play();
    String what();
    void adjust();
}

public class Class{
    public static void main(String[] args){

        Woodwind ww=new Woodwind();
        Brass bs=new Brass();
        ww.play();
        System.out.println(ww.what());
        bs.play();
        System.out.println(bs.what());
        Percussion ps=new Percussion();
        ps.play();



    }

}

