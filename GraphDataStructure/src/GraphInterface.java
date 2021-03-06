

public interface GraphInterface<T> {

    void addNode(String id, T value);

    void addEdge(String id1, String id2);

    void setNode(String id, T value);

    T getNode(String id);

    String[] getNodeIds();

    void removeNode(String id);

    void removeEdge(String id1, String id2);

    int countNodes();

    int countEdges();

    int genus();

    String toString();

}
