package Tester;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 2;
        array[2] = 8;
        array[3] = 1;
        array[4] = 3;
        array[5] = 0;
        array[6] = 9;
        array[7] = 7;

        System.out.print("Search for? ");
        int searching = Integer.valueOf(scanner.nextLine());

        // Implement the search functionality here
        int index = 0;
        boolean found = false;
        for(int i = 0; i < array.length; i++){
            if(array[i] == searching){
                index = i;
                found = true;
            }
        }
        if(found){
            System.out.println(searching + " is at index " + index + ".");
        }else{
            System.out.println(searching + " was not found.");
        }
    }
}
