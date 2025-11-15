import java.util.ArrayList;
import java.util.Stack;

public class pathTleaf {
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
    public static void pathTleave(node node,int sum,int low,int high,String path){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum>low && sum<high){
                path += node.data+" ";
                System.out.println(path);
            } 
            return;
        }
        pathTleave(node.left, sum+node.data, low, high, path+node.data+" ");
        pathTleave(node.right, sum+node.data, low, high, path+node.data+" ");
    }
    public static void display(node root) {
        if (root == null) return;
        String str = "";
        str += (root.left != null ? root.left.data : ".") + " <- " + root.data + " -> " + (root.right != null ? root.right.data : ".");
        System.out.println(str);
        display(root.left);
        display(root.right);
    }
    public static node leftCloneModified(node node){
        if(node == null){
            return null;
        }
        node leftClone = leftCloneModified(node.left);
        node rightClone = leftCloneModified(node.right);
        node.right = rightClone;
        node clone = new node(node.data, leftClone, null);
        node.left = clone;
        return node;
    }
    public static void leftClone(node node){// THIS CAN'T BE DONE IN PRE AREA AS WE ENCOUNTER THE CLONE AND RIGHT IS LOST WE KEEP GOING IN CLONE LOOP
        if(node == null){
            return;
        }
        leftClone(node.left);
        leftClone(node.right);
        node clone = new node(node.data, null, null);
        clone.left = node.left;
        node.left = clone;
        
    }
    public static void cloneHunter(node node){
        if(node == null ){
            return;
        }
        cloneHunter(node.left.left);
        cloneHunter(node.right);
        node leftActual = node.left.left;//BECAUSE WE NEED THAT TO NORMALOSE
        node.left = leftActual;
    }
    public static void printSingleChild(node node,node parent){
        if(node == null ){
            return;
        }
        if(parent != null && parent.left == null && parent.right != null){
            System.out.println(node.data);
        }else if(parent != null && parent.left != null && parent.right == null){
            System.out.println(node.data);
        }
        printSingleChild(node.left,node);
        printSingleChild(node.right,node); 
        if(node.left == null || node.right == null){
            System.out.println(node.data);
        }
    }
    public static node leafDestroyer(node node){//can delete root also
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            node = null;
            return node;
        }
        node.left = leafDestroyer(node.left);
        node.right = leafDestroyer(node.right);
        return node;
    }
    static class diPair{
        int height;
        int diameter;
        diPair(int height,int diameter){
            this.height = height;
            this.diameter = diameter;
        }
        diPair(){}
    }
    public static diPair diameterCalc500(node node){
        if(node == null){
            return new diPair(-1,0);
        }
        diPair left  = diameterCalc500(node.left);
        diPair right = diameterCalc500(node.right);
        diPair eff = new diPair(Math.max(left.height, right.height)+1,left.height+right.height+2);
        // eff.diameter = left.height+right.height+2;
        // eff.height = Math.max(left.height, right.height)+1;
        eff.diameter = Math.max(eff.diameter,Math.max(left.diameter, right.diameter));
        return eff;
    }
    public static int diameterCalc(node node){
        int left =  height(node.left);
        int right = height(node.right);
        int height = left + right +2;
        return height;
    }
    public static void diameter(node node){
        int leftDiameter = diameterCalc(node.left);
        int rightDiameter = diameterCalc(node.right);
        int diameter = diameterCalc(node);
        diameter = Math.max(diameter, leftDiameter);
        diameter = Math.max(rightDiameter, diameter);
        System.out.println(diameter);
    }
    public static int height(node node){
        if(node == null){
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int ht = Math.max(leftHeight, rightHeight)+1;
        return ht;
    }
    public static void leafDestroyer500(node node){//protects root
        if(node == null){
            return;
        }
        leafDestroyer500(node.left);
        leafDestroyer500(node.right);
        if(node.left != null && node.left.left == null && node.left.right == null){
            node.left = null;
        }
        if(node.right != null && node.right.left == null && node.right.right == null){
            node.right = null;
        }
    }
    public static class tiPair{
        int tilt;
        int sum;
        tiPair(int tilt,int sum){
            this.tilt = tilt;
            this.sum = sum;
        }
        tiPair(){}
    }
    static ArrayList<Integer> tiltarr;
    public static tiPair tilt(node node){
        if(node == null){
            return new tiPair(0,0);
        }
        tiPair left = tilt(node.left);
        tiPair right = tilt(node.right);
        tiPair eff = new tiPair();
        eff.sum = left.sum+right.sum+node.data;
        eff.tilt = Math.abs(left.sum-right.sum);
        tiltarr.add(eff.tilt);
        return eff;
    }
    static int tilt1;
    public static int tiltTree(node node){
        if(node == null){
            return 0;
        }
        int left = tiltTree(node.left);
        int right = tiltTree(node.right);
        int sum = left+right+node.data;
        int currTilt = Math.abs(left-right);
        tilt1+=currTilt;
        return sum;
    }
    public static void main(String[] args) {
        Integer[] construct = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        node root = constructor(construct);
        display(root);
        pathTleave(root, 0, 25, 250, "");
        // node newroot = leftCloneModified(root);
        // display(newroot);
        // leftClone(root);
        // System.out.println("cloned tree");
        // display(root);
        // cloneHunter(root);
        // System.out.println("actual tree");
        // display(root);
        printSingleChild(root, null);
        diameter(root);
        diPair diameter = diameterCalc500(root);
        System.out.println(diameter.diameter);
        tiltarr  = new ArrayList<>();
        tiPair roottilt = tilt(root);
        System.out.println("root tilt:"+roottilt.tilt);
        int treeTilt =0;
        for (int i = 0; i < tiltarr.size(); i++) {
            treeTilt += tiltarr.get(i);
        }
        System.out.println("tree tilt:"+treeTilt);
        tilt1 = 0;
        System.out.println("tree sum:"+tiltTree(root));
        System.out.println("tree tilt:"+tilt1);
    }
}
