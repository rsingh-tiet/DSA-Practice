import java.util.*;

public class treeAbstrct {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static class Ppair {
        Node node;
        int state;
        Ppair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static class GtPreOrderTrav implements Iterator<Integer> {
        Integer nVal;
        Stack<Ppair> stk = new Stack<>();

        public GtPreOrderTrav(Node root) {
            stk.push(new Ppair(root, -1));
            advance();
        }

        private void advance() {
            nVal = null;
            while (!stk.isEmpty()) {
                Ppair top = stk.peek();
                if (top.state == -1) {
                    nVal = top.node.data;
                    top.state++;
                    break;
                } else if (top.state == top.node.children.size()) {
                    stk.pop();
                } else {
                    stk.push(new Ppair(top.node.children.get(top.state), -1));
                    top.state++;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return nVal != null;
        }

        @Override
        public Integer next() {
            Integer res = nVal;
            advance();
            return res;
        }
    }

    public static class genericTree implements Iterable<Integer> {
        Node root;

        genericTree(Node root) {
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new GtPreOrderTrav(root);
        }
    }

    public static Node construct(int[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = null;

        for (int val : arr) {
            if (val == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = val;
                if (!st.isEmpty()) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }

    public static void display(Node n) {
        String s = n.data + " -> ";
        for (Node child : n.children) {
            s += child.data + " ";
        }
        System.out.println(s);
        for (Node child : n.children) {
            display(child);
        }
    }

    public static int diameter;
    public static int diameterReturnHt(Node n) {
        int deepChild = -1;
        int secondDeepChild = -1;
        for (Node chilNode : n.children) {
            int currHt = diameterReturnHt(chilNode);
            if (currHt > deepChild) {
                secondDeepChild = deepChild;
                deepChild = currHt;
            } else if (currHt > secondDeepChild) {
                secondDeepChild = currHt;
            }
        }
        diameter = Math.max(diameter, secondDeepChild + deepChild + 2);
        return deepChild + 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter size of tree array:");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter tree elements (use -1 to indicate end of children):");
        for (int i = 0; i < n; i++) arr[i] = scn.nextInt();

        Node root = construct(arr);
        display(root);

        genericTree gt = new genericTree(root);
        System.out.println("\nPreorder traversal using iterator:");
        for (int val : gt) {
            System.out.print(val + " ");
        }

        diameter = 0;
        diameterReturnHt(root);
        System.out.println("\nDiameter: " + diameter);
    }
}
