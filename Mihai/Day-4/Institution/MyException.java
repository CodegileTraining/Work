/**
 * Created by Mihai on 22.02.2016.
 */
public class MyException extends Exception {

}

class EmployeeNotFound extends MyException {

    public EmployeeNotFound() {
    }

    public EmployeeNotFound(String msg) {
        System.out.println(msg);
    }

}

class DateNotFound extends MyException {
    public DateNotFound() {
    }

    public DateNotFound(String msg) {
        System.out.println(msg);
    }

}
