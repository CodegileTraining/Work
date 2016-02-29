package package2;

import package1.Interface2;

/**
 * Created by Mihai on 25.02.2016.
 */
public class Class2 implements Interface2 {
    @Override//in a interface all fields are public so when we implements an interface without public it will clash with the declaration in
    //interface
    String c() {
        return null;
    }

    @Override
    public int a() {
        return 0;
    }
}
