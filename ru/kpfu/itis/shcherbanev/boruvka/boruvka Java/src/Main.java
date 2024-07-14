import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = countFiles("resources");;
        File file = new File(new File(System.getProperty("user.dir"), "statistics"), "stat.txt");
        file.delete();
        for (int i = 0; i < n; i++) {
            Graph graph = new Graph();
            graph.initializeByFile("resources/test" + i + ".txt");
            BoruvkasAlgorithm boruvka = new BoruvkasAlgorithm();
            long start = System.nanoTime();
            boruvka.boruvkaMST(graph);
            long time = System.nanoTime() - start;
            //System.out.println(graph.getVertNames().length + " " + graph.getEdgeNum());
            //System.out.println(boruvka.getIterationCount());
            //System.out.println(time / 1000000);
            getStat(graph.getVertNames().length, graph.getEdgeNum(), boruvka.getIterationCount(), time / 1000000);
        }
    }

    public static int countFiles(String folderPath) {
        File folder = new File(folderPath);
        int fileCount = 0;
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                fileCount++;
            }
        }
        return fileCount;
    }

    public static void getStat(int vertNum, int edgeNum, int iterCount, long time) throws IOException {
        File file = new File(new File(System.getProperty("user.dir"), "statistics"), "stat.txt");
        DataGenerator.createNewFile(file);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(vertNum + " " + edgeNum + " " + iterCount + " " + time + "\n");
        }
    }

}
