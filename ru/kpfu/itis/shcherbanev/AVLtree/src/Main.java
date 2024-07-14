import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/data.txt"));

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String line3 = scanner.nextLine();

        int[] data = convertStringToIntArray(line1);
        int[] search = convertStringToIntArray(line2);
        int[] delete = convertStringToIntArray(line3);

        // массивы для подсчета кол-во операций для каждого типа операции
        int[] operCounterInsert = new int[data.length];
        int[] operCounterSearch = new int[search.length];
        int[] operCounterDelete = new int[delete.length];


        // массивы для подсчета времени в наносекундах для каждого типа операции
        long[] nanosecInsert = new long[data.length];
        long[] nanosecSearch = new long[search.length];
        long[] nanosecDelete = new long[delete.length];

        AVLTree avlTree = new AVLTree();

        // insert
        for (int i = 0; i < data.length; i++) {
            avlTree.setOperationCounter(0);

            long nanoTimeStart = System.nanoTime();
            avlTree.insert(data[i]);
            long insertTime = System.nanoTime() - nanoTimeStart;
            nanosecInsert[i] = insertTime;

            operCounterInsert[i] = avlTree.getOperationCounter();
        }


        // search
        for (int i = 0; i < search.length; i++) {
            avlTree.setOperationCounter(0);

            long nanoTimeStart = System.nanoTime();
            avlTree.search(search[i]);
            long searchTime = System.nanoTime() - nanoTimeStart;
            nanosecSearch[i] = searchTime;

            operCounterSearch[i] = avlTree.getOperationCounter();
        }

        // delete
        for (int i = 0; i < delete.length; i++) {
            avlTree.setOperationCounter(0);

            long nanoTimeStart = System.nanoTime();
            avlTree.delete(delete[i]);
            long deleteTime = System.nanoTime() - nanoTimeStart;
            nanosecDelete[i] = deleteTime;

            operCounterDelete[i] = avlTree.getOperationCounter();
        }

        double avgOperInsert = Arrays.stream(operCounterInsert)
                                    .average()
                                    .orElse(-1);
        double avgOperSearch = Arrays.stream(operCounterSearch)
                                    .average().orElse(-1);
        double avgOperDelete = Arrays.stream(operCounterDelete).average()
                                    .orElse(-1);

        double avgTimeInsert = Arrays.stream(nanosecInsert)
                                    .average()
                                    .orElse(-1);
        double avgTimeSearch = Arrays.stream(nanosecSearch)
                                    .average()
                                    .orElse(-1);
        double avgTimeDelete = Arrays.stream(nanosecDelete)
                                .average()
                                .orElse(-1);


        String countInsert = "Среднее кол-во операций вставки - " + avgOperInsert;
        String countSearch = "Среднее кол-во операций поиска - " + avgOperSearch;
        String countDelete = "Среднее кол-во операций удаления - " + avgOperDelete;

        String timeInsert = "Среднее кол-во времени вставки - " + avgTimeInsert;
        String timeSearch = "Среднее кол-во времени поиска - " + avgTimeSearch;
        String timeDelete = "Среднее кол-во времени удаления - " + avgTimeDelete;

        System.out.println(countInsert);
        System.out.println(countSearch);
        System.out.println(countDelete);

        System.out.println(timeInsert);
        System.out.println(timeSearch);
        System.out.println(timeDelete);



//        System.out.println(Arrays.toString(operCounterInsert));
//        System.out.println(Arrays.toString(operCounterSearch));
//        System.out.println(Arrays.toString(operCounterDelete));
//
//        System.out.println(Arrays.toString(nanosecInsert));
//        System.out.println(Arrays.toString(nanosecSearch));
//        System.out.println(Arrays.toString(nanosecDelete));

        String[] avgArray = {countInsert, countSearch, countDelete, timeInsert, timeSearch, timeDelete};
        writeData("resources/stat.txt", operCounterInsert, operCounterSearch, operCounterDelete, nanosecInsert, nanosecSearch, nanosecDelete);
        writeAvg("resources/avgStat.txt", avgArray);
    }

    public static int[] convertStringToIntArray(String string) {
        String[] numbers = string.split("\\s+");
        int[] array = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        return array;
    }

    public static void writeData(String filename, int[] int1, int[] int2, int[] int3, long[] long1, long[] long2, long[] long3) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(Arrays.toString(int1).replace("[", "").replace("]", "") + "\n");
            bw.write(Arrays.toString(int2).replace("[", "").replace("]", "") + "\n");
            bw.write(Arrays.toString(int3).replace("[", "").replace("]", "") + "\n");
            bw.write(Arrays.toString(long1).replace("[", "").replace("]", "") + "\n");
            bw.write(Arrays.toString(long2).replace("[", "").replace("]", "") + "\n");
            bw.write(Arrays.toString(long3).replace("[", "").replace("]", ""));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeAvg(String filename, String ... data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < data.length; i++) {
                bw.write(data[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}