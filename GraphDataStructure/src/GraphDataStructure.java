

public class GraphDataStructure <T> implements GraphInterface <T> {

    protected class Node<T>{

         T value;
         Node [] connections;
         String id;

        /** This is a constructor
         *
         * @param value
         * @param id
         */
        public Node(T value, String id) {

            // initailize the node value,id and create a array of type node holding node connections

            this.value = value;
            this.id = id;
            connections = new Node[0];
        }

        /** This functions checks if a nodes has connections
         *
         * @param node
         * @return
         */
        boolean isConnected(Node node) {

            // if the node connections array is empty return false otherwise return true

            if (node.connections.length == 0) {
                return false;
            }
            return true;
        }

        /** This function connects two nodes
         *
         * @param node
         */
        void connectTo(Node node) {

            // creating tmp array one longer than the current array because we are adding a node

            Node [] tmp = new Node[connections.length+1];

            // copy over all of connections to tmp

            for (int i = 0; i < connections.length; i++){
                tmp[i] = connections[i];
            }

            // add the inputted node to the last element to tmp and copy over tmp to connections
            tmp[connections.length] = node;
            connections = tmp;
        }

        /** This functions disconnnects two nodes
         *
         * @param node
         */
        void disconnectFrom(Node node) {

            // creating tmp array one lesser than the current array because we are removing a node


            Node [] tmp = new Node[connections.length-1];
            int i;

            //loop thru connections and find the node that matches the inputted node

            for (i = 0 ; i < connections.length; i++){
                if (connections[i].id == node.id){
                    break;
                }

                // copy over connections to tmp at index i

                tmp[i] = connections[i];
            }

            // copy over tmp to connections but one less from tmp to remove node and than copy tmp to connections

            for (i++ ; i < connections.length; i++){
                tmp[i-1] = connections[i];
            }
            connections = tmp;
        }
    }

    int edgecount;
    Node[] nodes;

    /** Constructor for project3graph initializing the vars edgecout and creating a nodes array of type Node
     *
     */
    public GraphDataStructure() {
        edgecount = 0;
        nodes = new Node[0];

    }

    /** This functions add a node with a string id and value of type t to the graph
     *
     * @param id
     * @param value
     */
    @Override
    public void addNode(String id, T value) {

        // creating a array of size on greater than the current nodes length

        Node[] tmp = new Node[nodes.length+1];

        // loop loop to copy all nodes from nodes to tmp

        for (int i=0; i < nodes.length; i++){
            tmp[i] = nodes[i];
        }

        // add the new node to the end of tmp and copy tmp back to the original array nodes

        tmp[nodes.length] = new Node(value, id);
        nodes = tmp;

    }

    /** This functions takes an id and return the node that has that id in the graph
     *
     * @param id
     * @return
     */
    public Node FindNode(String id) {

        // loop thru array nodes and if the node.id at index i is equal to the string id input return that node which
        // is i otherwise return null as for there is no node in the graph with the input id

        for (Node i: nodes) {
            if (i.id == id) {
                return i;
            }
        }
        return null;
    }

    /** This functions takes in two ids and creating a connection between the two nodes with those id's
     *
     * @param id1
     * @param id2
     */
    @Override
    public void addEdge(String id1, String id2) {

        // create two node variable using the id parameters and the FindNode function which return a node using an id

        Node node1 = FindNode(id1);
        Node node2 = FindNode(id2);

        // if the nodes exist in the graph and they are not already connected, use the class nodes method connectTo to
        // connect the two nodes and increment edgecount

        if (node1 != null && node2 != null && !node1.isConnected(node2)){
            node1.connectTo(node2);
            node2.connectTo(node1);
            edgecount++;
        }
    }

    /** This functions replaces the id an value for an existing node
     *
     * @param id
     * @param value
     */
    @Override
    public void setNode(String id, T value) {

        //if the find node of the id equals none, then return nothing

        if (FindNode(id) == null){
            return;
        }

        // if then find the node with the matching id using findnode and replace it with a newnode that has the updated
        // values

        else {
            Node node1 = FindNode(id);

            for(int i = 0; i < nodes.length; i++){
            if (nodes[i] == node1){
                Node newnode = new Node(value, id);
                newnode = nodes[i];
            }
            }
        }
    }

    /** This functions returns the value at a node using an input of an id
     *
     * @param id
     * @return
     */
    @Override
    public T getNode(String id) {

        // loop thru nodes and if the id at index i is the same as the input id, return the value of type t at the node
        // at index i

        for (Node i: nodes) {
            if (i.id == id) {
                return (T) i.value;
            }
        }

        // otherwise return null

        return null;
    }

    /** This method return a string array of all the node id's inside the array nodes containg all the nodes in the graph
     *
     * @return
     */
    @Override
    public String[] getNodeIds() {

        // if the length of nodes is equal to 0, crete a string array of length 0

        if (nodes.length == 0) {
            return new String[0];
        }

        // create tmp string array of size of nodes

        String[] tmp = new String[nodes.length];

        // copy over to tmp all the nodes id's inside of the array nodes

        for (int i = 0; i < nodes.length; i++){
            tmp[i] = nodes[i].id;
        }
        return tmp;
    }

    /** This functions removes a node from the graph using its string id
     *
     * @param id
     */
    @Override
    public void removeNode(String id) {
        // compare to the node with this string id in parameter
        Node [] tmp = new Node[nodes.length-1];

        // loop thru nodes and find the value in it that has the same string id and the input id

        int i;
        for (i = 0 ; i < nodes.length; i++){
            if (nodes[i].id == id){
                break;
            }

            // copy over node to tmp

            tmp[i] = nodes[i];
        }
        // loop thru nodes and copy over tmp to node but minus 1 to tmp since we removed a node
        for (i++ ; i < nodes.length; i++){
            tmp[i-1] = nodes[i];
        }
        nodes = tmp;
    }

    /** This function intakes to node id's and disconnects their edges
     *
     * @param id1
     * @param id2
     */
    @Override
    public void removeEdge(String id1, String id2) {

        // create two node varibles using the id parameters and the FindNode function which return a node using an id

        Node node1 = FindNode(id1);
        Node node2 = FindNode(id2);

        // if the nodes are valid and they are connected use the private class node.disconnect from function to
        // disconnect them and minus from edgecount

        if (node1 != null && node2 != null && node1.isConnected(node2)){
            node1.disconnectFrom(node2);
            node2.disconnectFrom(node1);
            edgecount--;
        }
    }

    /** This function return the amount of nodes in the graph
     *
     * @return
     */
    @Override
    public int countNodes() {
        return nodes.length;
    }

    /** This functions returns the amount of edges in the graph
     *
     * @return
     */
    @Override
    public int countEdges() {
        return edgecount;
    }

    /** This function returns the genus value of the graph
     *
     * @return
     */
    @Override
    public int genus() {

        // function for finding the genus of a graph

        return 1 + edgecount - nodes.length;
    }

    /** This function returns the string version of the graph data strcuture
     *
     * @return
     */
    @Override
    public String toString() {

        // create string var

        String returnString = "";

        // use for loop to loop thru all nodes inside the nodes array and print the id and value in the correct
        // format for each

        for (Node i: nodes){
            returnString+= i.id + "("+ i.value + ")" + ":";

            // loop thru each nodes connections and print the its connections in the correct format

            for(Node j: i.connections){
                returnString += j.id + " ";
            }
            returnString+= "\n";
        }
        return returnString;
    }
}
