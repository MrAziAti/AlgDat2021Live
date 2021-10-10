package Tester;

public class CallStack {

    public static void main(String[] args) {
        skrivA();
    }

    public static void skrivA(){
        skrivB();
        skrivC();

    }

    public static void skrivB(){

        skrivC();

    }
    public static void skrivC(){

    }
}
