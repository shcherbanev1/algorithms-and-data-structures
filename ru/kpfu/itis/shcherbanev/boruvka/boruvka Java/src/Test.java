public class Test {

    public static void main(String[]args){
        Graph graph = new Graph();
        graph.initializeByFile("entryGraph.txt");
        System.out.println(graph);
        BoruvkasAlgorithm boruvka = new BoruvkasAlgorithm();
        boruvka.boruvkaMST(graph);
    }
}
