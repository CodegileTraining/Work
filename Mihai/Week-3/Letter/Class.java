import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mihai on 05.03.2016.
 */
public class Class {
    List<String> persons;
    Scanner template;
    Scanner sc;

    public Class() {
        persons = new ArrayList<>();
        try {
            sc = new Scanner(new File("Names.txt"));
            while (sc.hasNext())
                persons.add(sc.next());
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Class ob = new Class();

        try {
            ob.writeLetters();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLetters() throws IOException {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        String s;
        try {
            for (String x : persons) {
                template = new Scanner(new File("Template"));
                fileWriter = new FileWriter(x + ".txt");
                bufferedWriter = new BufferedWriter(fileWriter);
                s = template.nextLine().replace("X", x);
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                while (template.hasNext()) {
                    bufferedWriter.write(template.nextLine());
                    bufferedWriter.newLine();
                }
                template.close();
                bufferedWriter.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
