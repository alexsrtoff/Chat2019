package Lesson7;

public class SnakePrint {
    public static void main(String[] args) {
        int count = 0;
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int b[][] = new int[4][4];
        int x = 0;

        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i] + " ");
            count++;
            if(count != 0 && count % 4 == 0) System.out.println();

        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j <b[i].length ; j++) {
                b[i][j] = i + j + 1;
            }
        }
        x = 8;
        for (int i = b.length-1; i > 0; i--) {
            for (int j = b[i].length -2; j >= 0; j--) {

                b[i][j] = x;
                x++;
            }
//            System.out.println(i);
        }

//        for (int i = 1; i < b.length; i++) {
//            for (int j = 0; j <b[i].length -1 ; j++) {
//                b[i][j] = i + j + 11;
//            }
//        }


        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();

        }
    }
}
