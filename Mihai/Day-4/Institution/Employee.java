/**
 * Created by Mihai on 22.02.2016.
 */

import java.util.ArrayList;

public class Employee {

    String name;
    String type;
    ArrayList<Atention> atentions;

    public Employee(String name, String type) {
        this.name = name;
        this.type = type;
        atentions = new ArrayList<Atention>();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Atention> getAtention() {
        return atentions;
    }

    public void giveHimAtention(Atention ob) {
        atentions.add(ob);
    }

    public void removeAtentions() {
        atentions.clear();
    }
}

