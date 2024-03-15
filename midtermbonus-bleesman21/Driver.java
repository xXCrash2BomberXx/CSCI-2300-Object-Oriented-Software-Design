public class Driver {
    public static void main (String []args) {
        ArrayListSlice list = new ArrayListSlice();
        for (int i = 0; i < 10; i++)
            list.add(i*2);
        System.out.println(list.print());  // [0, 2, 4, 6, 8, 10, 12, 14, 18]
        System.out.println(list.print(4));  // [0, 2, 4, 6]
        System.out.println(list.print(3, 7));  // [6, 8, 10, 12]
        System.out.println(list.print(3, 9, 2));  // [6, 10, 14]
    }
}
