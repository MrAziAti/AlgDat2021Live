package Tester;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1Oppgave1 {
    public static void main(String[] args) {

        int [] a = {9,2,5,4,10,2,5,3,2};

        maks(a);
    }

    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom.");
        }
        int maks = a[0];
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;

                maks = temp;


                System.out.println(Arrays.toString(a));
            }


        }
        return maks;
    }


    public static int ombyttinger(int[] a) {

        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom.");
        }

        int teller = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    teller++;

                }
            }


        }
        return teller;
    }
}
