/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        // clone starting node
        Node cloneStart = new Node(node.val);
        map.put(node, cloneStart);

        q.add(node);

        while (!q.isEmpty()) {

            Node curr = q.remove();

            for (Node nbr : curr.neighbors) {

                // neighbor not cloned yet
                if (!map.containsKey(nbr)) {

                    map.put(nbr, new Node(nbr.val));
                    q.add(nbr);
                }

                // connect cloned nodes
                map.get(curr).neighbors.add(map.get(nbr));
            }
        }

        return map.get(node);
    }
}