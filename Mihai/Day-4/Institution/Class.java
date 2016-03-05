/**
 * Created by Mihai on 22.02.2016.
 */

import java.util.Scanner;

public class Class {

    public static void main(String[] args) {
        Institution ob = Institution.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "What do you want do to:\n1.Give someone Atention\n2.Get a report by Employees\n3.Get a report by costs\n4.Watch a report\n");
            switch (sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("Which nigga do you wanna feed?(Enter his Name)\n");
                    String name = sc.nextLine();
                    System.out.println("What do you want to give him?\n");
                    String atention = sc.nextLine();
                    System.out.println("How much do you spend for that pice of garbage?\n");
                    int value = sc.nextInt();
                    try {
                        ob.giveHimAtention(name, atention, value);
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    sc.nextLine();
                    break;
                case 2:
                    ob.raportByEmployes();
                    break;
                case 3:
                    ob.raportByAtentions();
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("What kind of report do you want?\n1.For each employee\n2.For costs");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("For what month do you want to see te raport?\n(Format:YYYY-MM \n");
                            try {
                                ob.seeRaport(sc.next(), " RaportbyEmployee.txt");
                            } catch (MyException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("For what month do you want to see te raport?\n(Format:YYYY-MM \n");
                            try {
                                ob.seeRaport(sc.next(), " RaportbyAtentions.txt");
                            } catch (MyException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            break;
                    }

                    sc.reset();
                    break;
                default:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}

