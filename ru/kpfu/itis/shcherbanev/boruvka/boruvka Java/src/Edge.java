import java.util.Objects;

public class Edge {

    private int src;
    private String srcName;
    private int dest;
    private int destName;
    private int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (src == edge.src && dest == edge.dest || src == edge.dest && dest == edge.src) && weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest, weight);
    }

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public int getDestName() {
        return destName;
    }

    public void setDestName(int desrName) {
        this.destName = desrName;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
