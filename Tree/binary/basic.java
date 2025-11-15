import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class basic {
    public static class node {
        int data;
        node left, right;
        node(int dataa, node left, node right) {
            this.data = dataa;
            this.left = left;
            this.right = right;
        }
    }

    public static class pair {
        node node;
        int state;
        pair(node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static node constructor(Integer[] arr) {
        node root = new node(arr[0], null, null);
        Stack<pair> stk = new Stack<>();
        stk.push(new pair(root, 0));

        int i = 1;
        while (!stk.isEmpty() && i < arr.length) {
            pair top = stk.peek();

            if (top.state == 0) {
                // left child
                if (arr[i] != null) {
                    node left = new node(arr[i], null, null);
                    top.node.left = left;
                    stk.push(new pair(left, 0));
                }
                top.state++;
                i++;

            } else if (top.state == 1) {
                // right child
                if (arr[i] != null) {
                    node right = new node(arr[i], null, null);
                    top.node.right = right;
                    stk.push(new pair(right, 0));
                }
                top.state++;
                i++;

            } else {
                // both children processed
                stk.pop();
            }
        }

        return root;
    }

    public static void display(node root) {
        if (root == null) return;
        String str = "";
        str += (root.left != null ? root.left.data : ".") + " <- " + root.data + " -> " + (root.right != null ? root.right.data : ".");
        System.out.println(str);
        display(root.left);
        display(root.right);
    }
    public static int size(node node){
        int size = 0;
        if(node == null){
            return 0;
        }else{
        int currsize = size(node.left);
        int rightsize = size(node.right);
        size = currsize+rightsize;
        size = size+1;}
        return size;
    }
    public static int sum(node node){
        int sum = 0;
        if(node == null){
            return 0;
        }else{
        int leftsum = sum(node.left);
        int rightsum = sum(node.right);
        sum = leftsum+rightsum;
        sum += node.data;
        }
        
        return sum;
    }
    public static int height(node node){
        if(node == null){
            return -1;// -1 for edge 0 for nodes
        }
        int left = height(node.left);
        int right = height(node.right);
        int height = Math.max(left, right);
        height++;
        return height;
    }
    public static int max(node node){
        if(node == null){
            return Integer.MIN_VALUE;//return the identity so that nothing changes like for addition 0 mul 1 
        }
        int left = max(node.left);
        int right = max(node.right);
        int max = Math.max(left, right);
        max = Math.max(max, node.data);
        return max;
    }
    public static void leveTraversal(node node){
        Queue<node> q = new ArrayDeque<>();
        q.add(node);
        while(!q.isEmpty()){
            node = q.remove();
            if(node != null){
                System.out.println(node.data);
                if(node.left != null){
                    q.add(node.left);
                }if(node.right != null){
                    q.add(node.right);
                }
            }else{
                continue;
            }
        }
    }

    public static void levelTraversalLine(node node){
        Queue<node> main = new ArrayDeque<>();
        Queue<node> helQueue = new ArrayDeque<>();
        main.add(node);
        while(!main.isEmpty()){
            node = main.remove();
            if(node != null){
                System.out.print(node.data+"\t");
                if(node.left != null){
                    helQueue.add(node.left);
                }
                if(node.right != null){
                    helQueue.add(node.right);
                }
            }
            if(main.isEmpty()){
                System.out.println();
                main = helQueue;
                helQueue = new ArrayDeque<>();
            }
        }
    }
    public  static void printKlevel(node node,int k){
        if(node == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.print(node.data +"\t");
        }
        printKlevel(node.left, k-1);
        printKlevel(node.right, k-1);
    }
    public static void iterativeOrder(node node){
       Stack<pair> stk = new Stack<>();
       stk.push(new pair(node, 0));
       String pre = "",in = "", post = "";
       while (!stk.isEmpty()) {
        pair top = stk.peek();
        if (top.state == 0) {
            pre += top.node.data+" ";
            top.state++;
            if(top.node.left != null){
                stk.push(new pair(top.node.left, 0));
            }
        }else if (top.state == 1) {
            in += top.node.data+" "; 
            top.state++;
            if(top.node.right != null){
                stk.push(new pair(top.node.right, 0));
            }
        }else{
            post += top.node.data+" ";
            stk.pop();
        }
       }
       System.out.println("pre:"+pre);
       System.out.println("post:"+post);
       System.out.println("in:"+in);
    }
    static ArrayList<node> nodeTorootPath;
    public static boolean isThere(node node ,int d){
        if(node == null){
            return false;
        }
        if(node.data == d){
            nodeTorootPath.add(node);
            return true;
        }
        boolean leftChild = isThere(node.left, d);
        if(leftChild){
            nodeTorootPath.add(node);
            return true;
        }
        boolean rightChild = isThere(node.right, d);
        if(rightChild){
            nodeTorootPath.add(node);
            return true;
        }
        return false;
    }
    public static void printKfar(node node,int k,int data){
        isThere(node, data);
        for (int i = 0; i < nodeTorootPath.size(); i++) {
            printKlevelModified(nodeTorootPath.get(i), k-i,i == 0? null:nodeTorootPath.get(i-1));
        }
    }
    public static void printKlevelModified(node node , int k,node block){
        if(node == null || node == block || k<0){
            return;
        }
        if( k == 0){
            System.out.print(node.data+"\t");
        }
        printKlevelModified(node.left, k-1, block);
        printKlevelModified(node.right, k-1, block);
    }
    public static ArrayList<Integer> nodeTrootPath(node node,int d){
        ArrayList<Integer> arr = new ArrayList<>();
        if(node == null){
            return new ArrayList<>();
        }
        if(node.data == d){
            arr.add(node.data);
            return arr;
        }
        ArrayList<Integer> leftChild = nodeTrootPath(node.left, d);
        if(!leftChild.isEmpty()){
            leftChild.add(node.data);
            return leftChild;
        }
        ArrayList<Integer> rightChild = nodeTrootPath(node.right, d);
        if(!rightChild.isEmpty()){
            rightChild.add(node.data);
            return rightChild;
        }
        return arr;
    }
    public static void traversal(node node){
        if(node == null){
            return;
        }
        System.out.println("pre:"+node.data);
        traversal(node.left);
        System.out.println("in:"+node.data);
        traversal(node.right);
        System.out.println("post:"+node.data);
        // System.out.println("pre:"+pre+"\nin:"+in+"\npost:"+post);
    }
    public static void main(String[] args) {
        Integer[] construct5 = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] construct7 = {//desnse
            10,
            20, 40, null, null, 50, 80, null, null, null,
            30, 60, null, 90, null, null, 70, null, null
        };
        Integer[] construct2 = {//skew
            10, 20, 30, 40, 50, null, null, null, null, null
        };
        Integer[] construct8 = {//semi balance
            1,
            2, 4, null, null, null,
            3, 5, 7, null, null, null, 6, null, null
        };
        Integer[] construct = {
            1,
            2,
            4,
                8, 16, null, null, 17, null, null,
                9, 18, null, null, 19, null, null,
            5,
                10, 20, null, null, 21, null, null,
                11, 22, null, null, 23, null, null,
            3,
            6,
                12, 24, null, null, 25, null, null,
                13, 26, null, null, 27, null, null,
            7,
                14, 28, null, null, 29, null, null,
                15, 30, null, null, 31, null, null
        };

        node root = constructor(construct);
        display(root);
        System.out.println("sum:"+sum(root));
        System.out.println("size:"+size(root));
        System.out.println("ht:"+height(root));
        System.out.println("max:"+max(root));
        // traversal(root);
        // leveTraversal(root);
        // levelTraversalLine(root);
        iterativeOrder(root);
        nodeTorootPath = new ArrayList<>();
        System.out.println(isThere(root, 62));
        for (node print : nodeTorootPath) {
            System.out.print(print.data+"\t");
        }
        System.out.print("\n"+nodeTrootPath(root, 62)+"\t");
        System.out.println();
        printKlevel(root, 2);
        nodeTorootPath = new ArrayList<>();
        System.out.println();
        printKfar(root, 3, 24);
    }
}
