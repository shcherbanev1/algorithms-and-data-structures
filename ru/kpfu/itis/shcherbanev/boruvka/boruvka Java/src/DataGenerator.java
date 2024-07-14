import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {

    public static void generateData(String fileName) throws IOException {
        String projectDirPath = System.getProperty("user.dir");
        File dataFolder = new File(projectDirPath, "resources");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File file = new File(dataFolder, fileName);
        createNewFile(file);

        try (FileWriter writer = new FileWriter(file)) {
            Random random = new Random();
            double probability = 0.1;
            int n = random.nextInt(9900) + 100;
            int m = (int) (random.nextInt(n*n) * 0.1); // т.к ребер слишком много и будет OutOfMemoryError, мы ограничили их кол-во

            writer.write(n + " " + m + "\n");
            for (int i = 0; i < n; i++) {
                writer.write(i + " " + i + "\n");
            }
            for (int i = 0; i < m; i++) {
                int a = random.nextInt(n);
                int b = random.nextInt(n);
                int c = random.nextInt(90) + 7;
                writer.write(a + " " + b + " " + c + "\n");
            }
        }
    }

    public static void createNewFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void deleteFiles(String folderPath) throws IOException {
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        deleteFiles("resources");
        System.out.println("старые входные данные удалены");
        Random random = new Random();
        int n = random.nextInt(50) + 50;
        for (int i = 0; i < n; i++) {
            DataGenerator.generateData("test" + i + ".txt");
        }
        System.out.println("новые входные данные созданы количество - " + n);
    }

}

