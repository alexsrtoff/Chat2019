package Lesson6;

public class MainClass {

    public int[] arrTest(int[] a){
        int count = 0;
        int[] b = new int[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 4){
                b = new int[a.length - (i + 1)];
                for (int j = 0; j < a.length - (i + 1); j++){
                    b[j] = a[i + j + 1];
                    count++;
                }
            }
        }
        if(count == 0){
            throw new RuntimeException("Проверяемый массив не содержит 4");
        }else return b;
    }

    public boolean arrayTest(int[] arr){
        int count = 0;
        boolean current = false;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == 1 || arr[i] == 4){
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == 4){
                        for (int o: arr){
                            if(o == 1){
                                current = true;
                            }
                        }
                    }
                }
            }else{
                current =  false;
                break;
            }
        }
        return current;
    }

    public void printArr(int[] arr){
        for(int o: arr){
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        int[] b;
        try {
            b = mainClass.arrTest(new int[]{1, 4, 3, 4, 5, 6, 7});
            mainClass.printArr(b);
            mainClass.arrTest(new int[]{1,2,3});
        }catch (RuntimeException e){
            e.printStackTrace();
       }
        System.out.println(mainClass.arrayTest(new int[]{1,1,1,1}));
        System.out.println(mainClass.arrayTest(new int[]{1,4,1,1}));
        System.out.println(mainClass.arrayTest(new int[]{4,4,4,4}));
        System.out.println(mainClass.arrayTest(new int[]{4,3,4,4}));
    }
}
