package Tester;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Oblig1Oppgave4 {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 5, 4, 6};
        int v = 0;
        int h = a.length-1;

        System.out.println("ARRAY FØR SORTERING");
        System.out.println(Arrays.toString(a));


        System.out.println("Skriver ut delsortering");
        delsortering(a);
        System.out.println(Arrays.toString(a));

    }
    public static void delsortering(int[] a) {

        int v = 0;
        int h = a.length -1;

        while (v < h) {
            while (a[v] % 2 != 0  && v < h )
                v++;

            while (a[h] % 2 == 0 && v < h ) {
                h--;
            }
            if (v < h) {
                int temp = a[v];
                a[v] = a[h];
                a[h] = temp;

            }


        }
        if(v == h && (v == a.length-1 || v == 0) ){
            kvikksortering0(a,0,a.length-1);
        }else{
            kvikksortering0(a,0,v-1);
            kvikksortering0(a,h,a.length-1);
        }


    }
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v,h, (v+h)/2);  // bruker midtverdien

        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]


    }
    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }
    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
