/**
 * Created by Mihai on 25.02.2016.
 */
public class Class {
    int a;
    String c;
    public Class(int a,String c){
        this.a=a;
        this.c=c;

    }
    void modifyB(){
        b=a; //here we get error because Class can't see the members of InnerClass, because InnerClass is private, and so his members
    }
    void modifyD(){
        d=c;//same here
    }


    class InnerClass{
        int b;
        String d;
        public InnerClass(int b,String d){
            this.b=b;
            this.d=d;
        }

        void modifyA(){
            a=b;//here we get no error because InnerClass is a member of Class and he can see the members of Class
        }
        void modifyC(){
            c=d;
        }



    }

}
