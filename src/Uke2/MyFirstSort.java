package Uke2;

public class MyFirstSort {

    public static void main(String[] args) {
        System.out.println("Hello algdat");

        int values[] = {1, 7, 2, 4, 6, 9};

        myFirstSort(values);
    }


    /**
     * Findmax - finner index til største tall i et array,
     * men søker bare innenfor tallene i [fra, til)
     */
    public static int findMax(int[] values, int fra, int til) {
        //Initialiser ved å se på første "kort"
        //Dette er det største tallet jeg har funnet
        //så langt
        int index = fra;
        int max_value = values[fra];

        //Sjekk at grensene for løkken er riktig.
        // [1, values.length)
        for (int i = fra + 1; i < til; ++i) {
            //Sjekk om vi har funnet nytt største tall
            if (values[i] > max_value) {
                max_value = values[i];
                index = i;
            }
        }

        return index;
    }
    /*
     * Denne funksjonen tar inn et array med verdier (heltall) og sorter dem "in place"
     *
     */
    public static void myFirstSort(int [] values){

        for (int k = 0; k < values.length - 1; ++k) {
            //Sjekk at vi får fornuftig svar for *ett* tilfelle.
            //Vi må utføre ordentlig testing før vi
            //faktisk kan stole på kildekoden vår
            int max_index = findMax(values, k, values.length);
            //System.out.println("Største verdi ligger på plass "
                   // + max_index + " og har verdi " + values[max_index]);

            //Bytte plass på tall på plass 0 og max_index
            int temp = values[k];
            values[k] = values[max_index];
            values[max_index] = temp;

            //System.out.println("Bytter plass " + k + " med plass " + max_index);
            //System.out.println("Arrayet etter ombytting");
            for (int i = 0; i < values.length; ++i) {
                //System.out.print(values[i] + ", ");
            }
            //System.out.println();
        }
    }
    /*
    * Findmax - finner index til største og nest største tall i et array.
    * men søker bare innen for tallene i [fra, til);
    * */

   /* public static int findTwoMaxIndices(int[] values, int fra, int til) {
        //Test at grensene gir mening
        if(til-fra < 2){
            throw new ArrayIndexOutOfBoundsException("Feil i grenser");
        }

        if(fra < 0){
            throw new ArrayIndexOutOfBoundsException("fra er negativ");
        }
        if(til <2){
            throw new ArrayIndexOutOfBoundsException("til er ikke lang nok");
        }
        //Test at vi ikke har for stor til-verdi
        //indekser:             0  1  2  3  4  5
        //values.length = 6;
        //Starter med verdiene {1, 7, 2, 4, 6, 9};
        if(til > values.length){
            throw new ArrayIndexOutOfBoundsException("til er utenfor tabellen");
        }


        //Initialiser ved å se på første to verdier (1,7)"
        //Dette er det største tallet  og nest største tallet jeg har funnet så langt
        int index_max = fra; // 1
        int index_nestmax = fra+1; //7

        int max_value = values[fra]; // 1
        int nest_max_value = values[fra+1]; // 7

        //Hvis nest_max_value har en verdsi som er større enn variabelen max_value så vi bytte dem.
        if(max_value < nest_max_value){
            // Disse burde refaktoreres i en swap(..) metode. for å gjøre koden mer lesbar og mindre sjanse for feil.
            int temp = max_value;
            max_value = nest_max_value;
            nest_max_value = temp;

            temp = index_max;
            index_max = index_nestmax;
            index_nestmax = temp;
        }
        // Status så langt
        // Array: {1, 7, 2, 4, 6, 9};
        // vi har sett på de to første elementene.
        // max_value = 8, index_max = 1
        // nest_max_value = 1, index_nestMax = 0
        // n åmå vi løpe igjennom resten av arrayet.

        //Sjekk at grensene for løkken er riktig.
        // [1, values.length)
        //Siden vi har sjekket de første tallene, begynner for løkken på fra+2
       /* for (int i = fra + 2; i < til; ++i) {

            //Tilfelle 1: nytt største tall

            if(values[i] > max_value){
                int temp = max_value;
                max_value = values[i];
                nest_max_value = temp;

                //Oppdaterer indeksene
                temp = index_max;
                index_max = i;
                index_nestmax = temp;
            }
            else if(values[i] > nest_max_value){
                nest_max_value = values[i];
                index_nestmax = i;
            }else{
                // Ingenting, max og nest max er større enn begge to
            }
            //Sjekk om vi har funnet nytt største tall
            if (values[i] > max_value) {
                max_value = values[i];
               // index = i;
            }
        }

        //return index;
    }*/

}
