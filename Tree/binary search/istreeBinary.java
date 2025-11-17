import java.util.Stack;

public class istreeBinary{
    public static class node {
        int data;
        node left, right;
        node(int dataa, node left, node right) {
            this.data = dataa;
            this.left = left;
            this.right = right;
        }
        node(){

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
    public static class bst{
        int max;
        int min;
        boolean isbst;
        bst(int max,int min,boolean isbst){
            this.max = max;
            this.min = min;
            this.isbst = isbst;
        }
        bst(){}
    }
    public static bst isbst(node node){
        if(node == null){
            return new bst(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        }
        bst left = isbst(node.left);
        bst right = isbst(node.right);
        bst eff = new bst();
        int max = Math.max(left.max, right.max);
        max = Math.max(max, node.data);
        int min = Math.min(left.min, right.min);
        min = Math.min(node.data, min);
        eff.min = min;
        eff.max = max;
        boolean check = left.isbst && right.isbst && node.data<=right.min && node.data>=left.max;
        eff.isbst =check;
        return eff;
    }
    public static void main(String[] args) {
        Integer[] construct = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null}; 
        Integer[] construct9 = {//skew
            10, 20, 30, 40, 50, null, null, null, null, null
        };
        Integer[] construct7 = {
            1, 
            2, 4, 5, null, null, null,  // left subtree (deep chain)
            3, null, null               // right subtree (balanced)
        };
        Integer[] construct8 = {50,25,null,null,75,null,null};
        node root = constructor(construct);
        display(root);
        bst binary = isbst(root);
        System.out.println(binary.isbst?"tree is bst":"tree is not nst");
    }
}