package find_max_and_write;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src/find_max_and_write/numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src/find_max_and_write/result.txt", maxValue);
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int item: numbers){
            if(item > max){
                max = item;
            }
        }
        return max;
    }
}
