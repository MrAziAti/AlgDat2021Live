package VideoForelesninger;

public class UsortertSøk {

    public static void main(String[] args) {
        int [] a = {2,3,4,7,9};

        System.out.println(usortertSøk(a,9));

    }
    //Metode som søker etter en bestemt verdi i en usortert Array;
    public static int usortertSøk(int[] a, int value){
        for(int i = 0; i < a.length; i++){
            if(a[i] == value){
                return i;
            }
        }
        return -1;
    }


}
