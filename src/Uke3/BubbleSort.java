package Uke3;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] values = {5, 6, 9, 2, 8, 3, 1, 10, 32, 4, 7, 14, 17, 18, 13};

        bubbleSort(values);

        System.out.println(Arrays.toString(values));
    }

    public static void bubbleSort(int[] values) {
        //To for-løkker:
        // Ytre løkke: sorterer ett tall per gjennomgang
        for (int i=0; i < values.length - 1; ++i) {
            System.out.println("Array før sortering av index " + i);
            System.out.println(Arrays.toString(values));
            // indre løkke: "bobler opp" tall til riktig posisjon
            for (int j=values.length-1; j > i; j--) {
                //Sjekk om tall på posisjon j og (j-1) er sortert riktig
                if (values[j] < values[j-1]) {
                    System.out.println("Inversjon! Bytter plass på " + j + " og " + (j-1) );
                    int tmp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = tmp;
                    System.out.println(Arrays.toString(values));
                }
            }
        }

        System.out.println("Sorterte verdier:");
        System.out.println(Arrays.toString(values));
    }
}
