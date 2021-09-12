package Uke3;

public class BinærSøk {
    public static void main(String[] args) {

    }

    public static int binarySearchRecursive(int[] values,
                                            int search_value,
                                            int l,
                                            int r) {
        int m = (l+r) / 2;

        if (l > r) {
            return -l;
        }

        if (values[m] > search_value) {
            r = m-1;
            return binarySearchRecursive(values, search_value, l, r);
        }
        else if (values[m] < search_value) {
            l = m+1;
            return binarySearchRecursive(values, search_value, l, r);
        }
        else if (values[m] == search_value) {
            return m;
        }
        else {
            //Something wrong
            System.out.println("Something wrong!, NaN etc.");
            return -m;
        }
    }


    public static int binarySearch(int[] values, int search_value) {
        //Intervaller:
        // Halvåpent intervall:
        // [8, 10) => 8 9 => vanlig for-løkke: for(int i=8; i<10; ++i)
        // (8, 10] => 9, 10
        // Lukket intervall:
        // [8, 10] => 8, 9, 10 => "vanlig" for-løkke: for(int i=8; i<=10; ++i)

        //Søk etter 6
        //[ l                 r ]
        //[ a b c d e f g h i j ]
        //[ 0 1 2 3 4 5 6 7 8 9 ]
        // values.length = 10
        // l = 0 //left index 0
        // r = 9 //right index 9
        // m = (l+r) / 2 = (0 + 9) / 2 = 4 //middle
        //Tanke: (0.0 + 9.0) / 2 // OBS: Double promotering

        //Tegneserie
        //1
        //[ l       m         r ]
        //[ a b c d 9 f g h i j ]
        //[ 0 1 2 3 4 5 6 7 8 9 ]

        //2
        //[ l m   r             ]
        //[ a 2 c d 9 f g h i j ]
        //[ 0 1 2 3 4 5 6 7 8 9 ]

        //3
        //[     lm r             ]
        //[ a 2 5 d 9 f g h i j ]
        //[ 0 1 2 3 4 5 6 7 8 9 ]
        // (l+r)/2 => (3+2)/2 = 5/2 = 2

        //4
        //[       lr            ]
        //[ a 2 5 7 9 f g h i j ]
        //[ 0 1 2 3 4 5 6 7 8 9 ]

        //Søk i intervallet [l, r]:
        int l = 0;
        int r = values.length - 1;
        int m = (l+r)/2;

        while (l <= r) {
            System.out.println("Sjekker intervallet [" + l + ", " + r + "]");
            m = (l+r)/2;
            //Hvis midt-verdien er større,
            //gå til venstre
            //[ l       m         r ]
            //[ a b c d 9 f g h i j ]
            if (values[m] > search_value) {
                //[ l     r             ]
                //[ a b c d 9 f g h i j ]
                r = m - 1;
            } else if (values[m] < search_value) {
                //[           l       r ]
                //[ a b c d 9 f g h i j ]
                l = m + 1;
            } else if (values[m] == search_value) {
                //Vi har funnet plassen til verdien.
                //eller NaN (f.eks. 9/0)
                return m;
            } else {
                System.out.println("Something wrong!");
            }
        }

        //Fant ikke verdien...
        return -l;
    }
}
