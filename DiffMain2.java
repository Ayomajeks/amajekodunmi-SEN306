// Java
class Box { 
    int value; 
}

public class DiffMain2 {

    public static void change(Box b, int x) {
        b.value = 99;       // affects original object
        b = new Box();      // local reassign, no effect outside
        x = 10;             // primitive unchanged outside
    }

    public static void main(String[] args) {
        Box myBox = new Box(); 
        myBox.value = 1;
        int a = 5;
        
        change(myBox, a);
        
        // This will print: myBox.value = 99, a = 5
        System.out.println("myBox.value = " + myBox.value + ", a = " + a);
    }
}