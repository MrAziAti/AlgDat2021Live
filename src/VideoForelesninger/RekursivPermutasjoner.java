package VideoForelesninger;

import java.util.Arrays;

public class RekursivPermutasjoner {

    public static void main(String[] args) {
        System.out.println("RekursvivPermutasjon");
        int values[] = {1,2,3};
        //1,2,3
        //1,3,2
        //2,1,3
        //2,3,1
        //3,1,2
        //3,2,1
        recursive_permutation(values, 0);
    }
    //
    static void recursive_permutation(int [] values, int k){
        if(k == values.length -1) {
            System.out.println(Arrays.toString(values));

        }
        for(int i = k; i<values.length; i++){
            swap(values, i,k);
            recursive_permutation(values, k+1);
            //System.out.println(Arrays.toString(values));
            swap(values, i,k);
        }
        //recursive_permutation(values);
    }

    static void swap(int []values, int m, int n){

        int temp = values[m];
        values[m] = values[n];
        values[n] = temp;
    }
}
