package VideoForelesninger;

public class CircularBuffer {
    char[] buffer;
    int size;
    int head; // Peker til starten av køen
    int tail; // Peker til slutten av køen
    int count; // Antall elementer i køen nå

    public CircularBuffer(int size) {
        this.buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public void pushBack(char value) {
        if(count + 1 > size){
            throw new IndexOutOfBoundsException();
        }
        buffer[tail] = value;
        tail = (tail + 1) % size;
        count = count +1;
    }

    public char popFron() {
        if(count <= 0){
            throw new IndexOutOfBoundsException();
        }
        char retval = buffer[head];
        System.out.print(head);
        head = (head + 1) % size;
        count = count -1;
        return retval;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(7);
        char[] values = "ABCDEFGHIJKLMNOPQRST".toCharArray();
        for (int i=0; i<values.length; ) {
            //Legg inn tre bokstaver i bufferet
            for (int j=0; j<6; ++j) {
                if (values.length > i+j) {
                    buffer.pushBack(values[i+j]);
                }
            }

            //Ta ut alt fra bufferet.
            while (buffer.count() > 0) {
                System.out.print(buffer.popFron());
            }
            System.out.println();

            i = i+6;
        }

    }
}
