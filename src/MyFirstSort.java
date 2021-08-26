import java.util.Arrays;

public class MyFirstSort {

    public static void main(String[] args) {
        System.out.println("Hello algdat");

        int vals[] = {1, 7, 2, 4, 6, 9};

        for (int k = 0; k < vals.length - 1; k++) {


            //sjekk at vi får fornuftig svar for "ett" tilfellet.
            //Vi må utfre ordentlig testing for vi faktisk kan stole på kildekoden vår.
            int maxIndex = findMax(vals, 0, vals.length);
            System.out.println("Største verdi ligger på plass " + maxIndex + " og har verdi " + vals[maxIndex]);

            //Bytte plass på tall på plass 0 og max index.
            int temp = vals[k];
            vals[k] = vals[maxIndex];
            vals[maxIndex] = temp;

            System.out.println("Array etter ombytting");
            for (int i = 0; i < vals.length; i++) {
                System.out.print(vals[i] + ", ");
            }
        }
    }

    //Findmax - finner index til største tall i et array
    // men søker bare innenfor tallene [fra, til]
    public static int findMax(int[] val, int fra, int til) {
        //Initialiser ved å se på første "kort"
        //Dette er det størtste tallet jeg har funnet så langt
        int max = val[fra];
        int index = fra;

        //Sjekk at grensene for løkken er riktig

        for (int i = fra + 1; i < til; i++) {
            //Sjekk om vi har funnet nytt største tall
            if (val[i] > max) {
                max = val[i];
                index = i;
            }
        }
        return index;
    }
}
