public class Main {
    public static void main(String[] args) {
        int[] array = {5,3,6,345,3,2,1};
        int index = minValue(array);
        System.out.println("The smallest element in the array is: " + array[index]);
    }

    private static int minValue(int[] array) {
        int index = 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}