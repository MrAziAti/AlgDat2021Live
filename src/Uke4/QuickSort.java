package Uke4;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] values = {8,5,3,6,5,2,9};
        System.out.println(Arrays.toString(values));
        quicksort(values,0,values.length-1);
        System.out.println(Arrays.toString(values));
    }

    /***
     * Rekursiv funksjon som implementerer kvikksort og sorterer
     * verdier i intervallet [left, right] - lukket intervall
     * @param values
     * @param left
     * @param right
     */

    static void quicksort(int[] values, int left, int right) {
        //Hvis vi ikke har noe intervall igjen (l == right)
        // så slutter vi rekursjonen
        if( left >= right){
            System.out.println("Slutter rekursjon");
            return;
        }
        //1. Bytt på midterste verdi i arrayet til slutten
        // - se på verdien. Dette er skilleverdien(Pivot)

        int m = left + right / 2;       // Index til midterste verdi
        int pivot = values[m];            // tar vare på midtverdien i en temp variabel
        values[m] = values[right];      //overskric midt variabelen med siste verdi i arrayet
        values[right] = pivot;            // Overskriv siste verdi i arrayet med temp variabelen(midten)
        System.out.println("Pivot er indeks " + m + " verdi: " + pivot);
        //2. Partisjoner arrayet fra start til "nest siste kort"(Siste kort er midt verdien)
        // - Flytt alt som er større enn eller lik skikkeverdi til høyre.
        // - Flytt alt som er mindre enn skikkevrdi til venstre
        // - Ta vare på indexden til den siste verdien som er mindere enn skilleverdi
        int index = partition(values, pivot, left, right - 1);

        //3. Flytt skille verdien (siste i arrayet) tilbake til riktig sortert plass
        // - (rett til høyre for siste verdi som er mindre enn skilleverdi i punk 2
        int sorted_index = index + 1;
        int tmp = values[sorted_index];
        values[sorted_index] = values[right];
        values[right] = tmp;
        System.out.println("Flytter pivot tilbake plass til indeks " + sorted_index);
        System.out.println("FLytter pivot " + m + "-" + right);


        //4 gjenta for høyre sub-array og venstre sub-array
        System.out.println("Rekursjon venstre subarray");
        quicksort(values, left, sorted_index - 1);
        System.out.println("Rekursjon høyre subarray");
        quicksort(values, sorted_index + 1, right-1);
    }

    /**
     * Partisjonerer arrayet basert på en skilleverdi, pivot.
     * Vi plasserer alle verdier somer mindre enn pibot til venstre
     * og alle verdier som er større eller lik til høyere. Vi returnerer
     * til slutt indeksen tiul siste tall som er mindre enn pivot.
     *
     * @param values
     * @param left
     * @param right
     * @return
     */
    static int partition(int[] values, int pivot, int left, int right) {
        int l = left;
        int r = right;

        //Kjør løkke helt til høyre og høyre peker møtes på midten
        //Da har vi funnet riktig plasseringav pivot
        while (l < r) {
            //flytt venstre peker mot høyre så lenge vi har tall som er riktig sortert som er sortert i forhold til pivot.
            while (l <= r && values[l] < pivot) {
                l++;
            }
            //Gjør tilsvarende for høyre peker - flytt mot venstre
            //Så lenge vi har tall some r større eller lik pivot
            while (l <= r && values[r] >= pivot) {
                r--;
            }
            //nå hat vi at values[l] >= pivot og values[values[r] < pivot
            //Disse kan byttes
            if (l < r) {
                System.out.println("Bytter " +  l +  "- " + r);
                int tmp = values[r];
                values[r] = values[l];
                values[l] = tmp;
                l++;
                r--;
            }
        }
        System.out.println("Siste tall  mindre en n pivot er på indeks " + (l-1));
        return l-1;
    }
}
