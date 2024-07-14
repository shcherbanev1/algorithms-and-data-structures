import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {

    public static void main(String[] args) {
        int arraySize = 10000;
        int forSearch = 100;
        int forDelete = 1000;

        Random random = new Random();

        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(0, 100000);
        }

        int[] forSearchArray = new int[forSearch];
        for (int i = 0; i < forSearch; i++) {
            int randomIndex = random.nextInt(arraySize);
            forSearchArray[i] = array[randomIndex];
        }

        int[] forDeleteArray = new int[forDelete];
        for (int i = 0; i < forDelete; i++) {
            int randomIndex = random.nextInt(arraySize);
            forDeleteArray[i] = array[randomIndex];
        }

        try (FileWriter fileWriter = new FileWriter("resources/data.txt")) {
            for (int number : array) {
                fileWriter.write(number + " ");
            }
            fileWriter.write("\n");

            for (int number : forSearchArray) {
                fileWriter.write(number + " ");
            }
            fileWriter.write("\n");

            for (int number : forDeleteArray) {
                fileWriter.write(number + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
