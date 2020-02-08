package Lesson7;

import java.util.Scanner;

public class ArraySnakePrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива:");
        final int x = scanner.nextInt();
        final int y = scanner.nextInt();
        int num = 1;
        int[][] arr = new int[x][y];
        int count;
        for (count = 1;;count++){
            if (num == x * y+1) break;
            for (int i = 0; i < 4; i++) {
                if(i == 0){
                    for (int j = count-1; j < y - count +1; j++, num++) {
                        arr[count-1][j] = num;

                    }
                }
                if ((i == 1)){
                    for (int j = count; j < x - count+1; j++, num++) {
                        arr[j][y - count] = num;
                    }
                }
                if(i == 2){
                    for (int j = y - count - 1; j >= count - 1 ; j--, num++) {
                        arr[x-count][j] = num;
                    }
                }
                if (i == 3){
                    for (int j = x - count - 1; j >= count; j--, num++) {
                        arr[j][count-1] = num;
                    }
                }


            }

        }
        printArr(arr);

    }
    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
