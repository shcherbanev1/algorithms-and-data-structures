import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

    private int vertNum;
    private int edgeNum;
    private Set<Edge> edges = new HashSet<>();
    private String[] vertices;

    public Graph(){

    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public Graph(int vertNum, int edgeNum){
        this.vertNum = vertNum;
        this.edgeNum = edgeNum;
    }

    //Method to initialize the Graph
    //It receives a path to a File that contains the edges of the Graph
    //First line contains verNum and edgeNum
    //Following lines represent the edges in the format:
    // src dest weight
    public void initializeByFile(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            String[] entryValues = line.split(" ");
            this.vertNum = Integer.parseInt(entryValues[0]);
            this.edgeNum = Integer.parseInt(entryValues[1]);
            this.vertices = new String[vertNum];
            this.edges = new HashSet<>();

            for(int i = 0; i < this.vertNum; i++){
                line = br.readLine();
                String[] aux = line.split(" ");
                vertices[Integer.parseInt(aux[0])] = aux[1];
            }

            while((line = br.readLine()) != null) {
                String[] edgeValues = line.split(" ");
                edges.add(new Edge(Integer.parseInt(edgeValues[0]), Integer.parseInt(edgeValues[1]), Integer.parseInt(edgeValues[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getVertNames(){
        return this.vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public int getVertNum() {
        return vertNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

}
