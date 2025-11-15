import java.util.Stack;

public class isBalance {
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
    public static boolean flag;
    public static int isBalanced(node node){
        if(flag == true){
            if(node == null){
                return -1;
            }
            int left = isBalanced(node.left);
            int right = isBalanced(node.right);
            int height = Math.max(left, right)+1;
            if(Math.abs(left-right) >1){
                flag = false;
            }else{
                flag = true;
            }
            return height;
        }else{
            return 0;
        }
    }
    public static boolean zhc = true;
    public static int improvedBalance(node node){
        if(node == null){
            return -1;
        }
        int left = improvedBalance(node.left);
        int right = improvedBalance(node.right);
        if(Math.abs(left-right)>1){
            zhc = false;
        }
        return Math.max(left, right)+1;
    }
    public static class balPair{
        boolean balance;
        int height;
        balPair(boolean balance,int height){
            this.balance = balance;
            this.height = height;
        }
        balPair(){}
    }
    public static balPair isTreeBal(node node){
        if(node == null){
            return new balPair(true,-1);
        }
        balPair left = isTreeBal(node.left);
        balPair right = isTreeBal(node.right);
        
        return new balPair((Math.abs(left.height-right.height)<=1&& left.balance && right.balance),
                                Math.max(left.height, right.height)+1);
    }
    public static void main(String[] args) {
        Integer[] construct2 = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null}; 
        Integer[] construct7 = {//skew
            10, 20, 30, 40, 50, null, null, null, null, null
        };
        Integer[] construct = {
            1, 
            2, 4, 5, null, null, null,  // left subtree (deep chain)
            3, null, null               // right subtree (balanced)
        };

        node root = constructor(construct);
        display(root);
        flag = true;
        isBalanced(root);
        System.out.println(flag ? "tree is balanced":"tree is not balanced");
        balPair treeBalance = isTreeBal(root);
        System.out.println(treeBalance.balance);

    }
}
