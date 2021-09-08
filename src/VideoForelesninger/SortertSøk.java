package VideoForelesninger;

public class SortertSøk {

    public static void main(String[] args) {

        int[] a = {2,3,4,7,9};
    }

    public static int sortertSøk1(int[] a, int value){
        for(int i= 0; i < a.length; i++){
            if(a[i] == value);
            return i;
        }
        return -1;
    }

    int sortertSøk2(int[] a, int value){
        int stepLength = 2;

        for(int i = 0; i< a.length; i = i+stepLength){
            if(a[i] >= value){
                int begin = i -stepLength;
                int end = i +1;

                for(int j = begin; j < end; j++){
                    if(a[j] == value){
                        return j;
                    }
                }
                return -1;
            }
        }
        return -1;
    }
}
