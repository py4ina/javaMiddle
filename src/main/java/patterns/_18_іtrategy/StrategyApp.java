package patterns._18_іtrategy;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        client.setStrategy(new SelectionSort());
        client.executeStrategy(arr0);

        int[] arr1 = {11, 4, 2, 7, 8, 5};
        client.setStrategy(new InsertingSort());
        client.executeStrategy(arr1);

        int[] arr2 = {3, -8, 2, 0, 33, 5};
        client.setStrategy(new BubbleSort());
        client.executeStrategy(arr2);
    }
}

/**Context**/
class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

/**Strategy**/
interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("BubbleSort.sort()");
        System.out.println("arr[] before = " + Arrays.toString(arr));
        for (int barier = arr.length - 1; barier >= 0 ; barier--) {
            for (int i = 0; i < barier; i++) {
                if (arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println("arr[] after = " + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("SelectionSort.sort()");
        System.out.println("arr[] before = " + Arrays.toString(arr));
        for(int barier = 0; barier < arr.length-1 ; barier++) {
            for(int i = barier+1; i < arr.length; i++) {
                if (arr[i] < arr[barier]){
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
        System.out.println("arr[] after = " + Arrays.toString(arr));
    }
}

class InsertingSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("InsertingSort.sort()");
        System.out.println("arr[] before = " + Arrays.toString(arr));
        for(int barier = 1; barier < arr.length; barier++) {
            int index = barier;
            while (index-1>0 && arr[index]<arr[index-1]){
                int tmp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = tmp;
                index--;
            }
        }
        System.out.println("arr[] after = " + Arrays.toString(arr));
    }
}