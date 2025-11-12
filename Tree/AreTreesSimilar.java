import java.util.*;

public class AreTreesSimilar {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // Function to construct a tree from an array representation
    public static Node construct(int[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = null;

        for (int val : arr) {
            if (val == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = val;

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }
    
    // Function to check if two trees are structurally similar
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if (!areSimilar(c1, c2)) {
                return false;
            }
        }
        return true;
    }
    public static boolean areMirror(Node n1,Node n2){
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for(int i = 0,j = n2.children.size()-1;i<n1.children.size() && j>=0; i++,j--){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if(!areMirror(c1, c2)){
                return false;
            }
        }
        return true;
    }
    public static boolean isSmmetric(Node n){
        return areMirror(n, n);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Input for first tree
        System.out.println("Enter size of first tree array:");
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter first tree elements (use -1 to indicate end of children):");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        // Input for second tree
        System.out.println("Enter size of second tree array:");
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter second tree elements (use -1 to indicate end of children):");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        Node root1 = construct(arr1);
        Node root2 = construct(arr2);

        boolean ans = areMirror(root1, root2);
        System.out.println(ans ? "Trees are structurally similar." : "Trees are NOT similar.");
        boolean symmetric = isSmmetric(root2);
        System.out.println(symmetric ? "tree is symmetric":"tree is not symmetric");
    }
}
