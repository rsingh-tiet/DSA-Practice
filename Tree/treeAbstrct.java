import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class treeAbstrct {
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
    static int size,height,max,min;
    static Node predecessor,sucessor;
    static int stage;
    static int ceil,floor;
    static Node maxNode;
    static int maxSum;
    static int diameter;

    public static int diameterReturnHt(Node n){
        int deepChild = -1;
        int secondDeepChild = -1;
        for (Node chilNode : n.children) {
            int currHt = diameterReturnHt(chilNode);
            if(currHt>deepChild){
                deepChild = currHt;
                secondDeepChild = deepChild;
            }else if(currHt>secondDeepChild){
                secondDeepChild = currHt;
            }
        }
        diameter = Math.max(diameter, secondDeepChild+deepChild+2);
        deepChild++;
        return deepChild;
    }

    public static int maxSubSum(Node n){
        int sum = 0;
        
        for (Node chNode : n.children) {
            int currSum = maxSubSum(chNode);
            sum += currSum; 
        }
        sum += n.data;
        if(sum>maxSum){
            maxSum = sum;
            maxNode = n;
        }
        return sum;
    }
    public static void ceilFloor(Node n , int d){
        if(n.data > d){
            ceil = Math.min(ceil, n.data);
        }else if(n.data<d){
            floor = Math.max(n.data, floor);
        }
        
        for (Node cNode : n.children) {
            ceilFloor(cNode, d);
        }
    }
    public static void kLargest(Node n,int k){
        floor = Integer.MIN_VALUE;
        int start = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ceilFloor(n, start);
            start = floor;
            floor = Integer.MIN_VALUE;// imp to reset floor again
        }
    }
    public static void presuu(Node n,int d){
        if(stage == 0){
            if(n.data == d){
                stage =1;
            }else{
                predecessor = n;
            }
        }else if(stage == 1){
            sucessor = n;
            stage = 2;
            return;
        }

        for (Node child : n.children) {
            presuu(child, d);   
        }
    }
    public static void display(Node n){
        String s  = new String();
        s = n.data+"->";
        for (Node child : n.children) {
            s+=child.data+" ";
        }
        System.out.println(s);
        for (Node childNode : n.children) {
            display(childNode);
        }
    }
    public static void catcher
    (Node node,int depth)
    {
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(depth, height);
        for (Node chNode : node.children) {
            catcher(chNode, depth+1);
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        size = 0;
        height = 0;
        stage = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
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
        display(root1);
        // presuu(root2,40);
        // System.out.println(predecessor.data);
        // System.out.println(sucessor.data);
        // ceil = Integer.MAX_VALUE;
        // floor = Integer.MIN_VALUE;

        // maxNode = null;
        // maxSum = Integer.MIN_VALUE;
        // maxSubSum(root2);
        // System.out.println(maxSum+"@"+maxNode.data);

        diameter = 0;
        diameterReturnHt(root2);
        System.out.println("diameter "+diameter);
    }
}
