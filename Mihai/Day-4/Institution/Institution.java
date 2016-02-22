/**
 * Created by Mihai on 22.02.2016.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class Institution {

    private static final Institution instance = new Institution();
    HashMap<String, Employee> employees;
    HashMap<String, Integer> atentions;

    private Institution() {
        employees = new HashMap<String, Employee>();
        atentions = new HashMap<String, Integer>();
        try {
            Scanner sc = new Scanner(new java.io.File("fis.in"));
            while (sc.hasNextLine()) {
                Employee ob = new Employee(sc.next() + " " + sc.next(), sc.next());
                employees.put(ob.getName(), ob);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("fisier inexistent");
        }

    }

    public static Institution getInstance() {
        return instance;
    }

    public void giveHimAtention (String name, String atention, int value) throws MyException{
        Employee ob = employees.get(name);
        if(ob==null)
            throw new EmployeeNotFound("Nigga not found");
        ob.giveHimAtention(new Atention(atention, value));
        employees.put(ob.getName(), ob);
        if (atentions.containsKey(atention))
            atentions.put(atention, value + atentions.get(atention));
        atentions.put(atention, value);

    }

    public void raportByAtentions() {
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = new String("");
        for (int i = 0; i < 6; i++) {
            if(i==4)
                fileName=fileName+"-";
            fileName = fileName + date.charAt(i);
        }
        try {
            PrintWriter writer = new PrintWriter(fileName + " RaportbyAtentions.txt", "UTF-8");
            for (Map.Entry<String, Integer> entry : atentions.entrySet()) {
                String s = entry.getKey();
                Integer i = entry.getValue();
                writer.println(s + " " + i);
            }
            atentions.clear();
            writer.close();

        } catch (IOException e) {

        }
    }

    public void raportByEmployes() {
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = new String("");
        for (int i = 0; i < 7; i++) {
            fileName = fileName + date.charAt(i);
        }
        try {
            PrintWriter writer = new PrintWriter(fileName + " RaportbyEmployee.txt", "UTF-8");
            for (Map.Entry<String, Employee> entry : employees.entrySet()) {
                String s = entry.getKey();
                Employee i = entry.getValue();
                ArrayList<Atention> atentionsEmployee = i.getAtention();
                writer.println(s);
                for (Atention x : atentionsEmployee) {
                    writer.print(x.getName() + " " + x.getValue());
                }
                i.removeAtentions();
                employees.put(s, i);
                writer.println();
                writer.println();
            }
            writer.close();

        } catch (IOException e) {

        }
    }

    public void seeRaport(String date, String type) throws MyException {
        try {
            date = date + type;
            File file=new File(date);
            if(file.exists()!=true)
                throw new DateNotFound("raport not found");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Raport is mising!\n");
        }
    }

}
