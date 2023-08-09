import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] arr = new int[100000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
        stopWatch.start();
        selectionSort(arr);
        stopWatch.stop();
        System.out.println("Thời gian bắt đầu: " + stopWatch.getStartTime());
        System.out.println("Thời gian kết thúc: " + stopWatch.getEndTime());
        System.out.println("Thời gian thực thi thuật toán: " + (stopWatch.getEndTime() - stopWatch.getStartTime())/1000 + "s");
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min_i]) {
                    min_i = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_i];
            arr[min_i] = temp;
        }
    }
}