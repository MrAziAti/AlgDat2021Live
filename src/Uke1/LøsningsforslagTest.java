package Uke1;

import static org.junit.jupiter.api.Assertions.*;

class LøsningsforslagTest {

    @org.junit.jupiter.api.Test
    void findMax() {
        int values[] = {1, 7, 2, 4, 6, 9};
        int index = Løsningsforslag.findMax(values,0,values.length);

        assertEquals(5,index);
        assertEquals(9, values[index]);
    }

    @org.junit.jupiter.api.Test
    void myFirstSort() {

        int values[] = {1, 7, 2, 4, 6, 9};

        Løsningsforslag.myFirstSort(values);

        int truth[] = {9,7,6,4,2,1};
        assertArrayEquals(truth, values);
    }
}