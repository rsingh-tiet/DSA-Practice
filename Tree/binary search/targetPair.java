import java.util.ArrayList;
import java.util.Stack;

public class targetPair {
    public static class node {
        int data;
        node left;
        node right;
        node(){}
        node(int data,node left,node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class pair{
        node node;
        int state;
        pair(){}
        pair(node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static node construct(int[] arr,int low,int high){
        if(low>high)return null;
        int mid = (low + high)/2;
        node left = construct(arr, low, mid-1);
        node right = construct(arr, mid+1, high);
        return new node(arr[mid], left, right);
    }
    public static void display(node node){
        if(node == null){
            return;
        }
        String str = (node.left != null?node.left.data:".")+"<-"+node.data+"->"+(node.right != null?node.right.data:".");
        System.out.println(str);
        display(node.left);
        display(node.right);
    } 
    public static boolean isThere(node node,int data){
        if(node == null)return false;
        if(node.data > data){
             return isThere(node.left, data);
        }else if(node.data < data){
           return isThere(node.right, data);
        }
        return true;
    }
    public static ArrayList<Integer> array;
    public static void inorder(node node){
        if(node == null){return;}
        inorder(node.left);
        array.add(node.data);
        inorder(node.right);
    }
    public static void target1(node root,node node,int target){
        if(node == null) return;
        target1(root,node.left, target);
        int complement = target-node.data;
        if(node.data<complement){
            if(isThere(root, complement)) System.out.println(node.data+" "+complement);
        }
        target1(root, node.right, target);
    }
    public static void target2(ArrayList<Integer> arr,int target){
        int i = 0, j = arr.size()-1;
        while (i < j) {
            int left = arr.get(i);
            int right = arr.get(j);
            if(left+right == target){
                System.err.println(left+" "+right);
                i++;j--;
            }else if(left + right > target){
                j--;
            }else if(left + right < target){
                i++;
            }
        }
    }
    public static node reverseIn(Stack<pair> stk){
        while (!stk.isEmpty()) {
            pair top = stk.peek();
            if(top.state == 0){//pre
                if(top.node.right != null){
                    stk.push(new pair(top.node.right,0));
                }
                top.state++;
            }else if(top.state == 1){//in
                if(top.node.left != null){
                    stk.push(new pair(top.node.left,0));
                }
                top.state++;
            }else{//post
                stk.pop();
                return top.node;
            }
        }
        return null;
    }
    public static node In(Stack<pair> stk){
        while (!stk.isEmpty()) {
            pair top = stk.peek();
            if(top.state == 0){//pre
                if(top.node.left != null){
                    stk.push(new pair(top.node.left,0));
                }
                top.state++;
            }else if(top.state == 1){//in
                if(top.node.right != null){
                    stk.push(new pair(top.node.right,0));
                }
                top.state++;
            }else{//post
                stk.pop();
                return top.node;
            }
        }
        return null;
    }
    public static void targetBest(node node,int target){
        Stack<pair> leftStk = new Stack<>();
        Stack<pair> rightStk = new Stack<>();
        leftStk.push(new pair(node, 0));
        rightStk.push(new pair(node, 0));

        node left = In(leftStk);
        node right = reverseIn(rightStk);
        while (left != null && right != null && left.data < right.data) {
            if(left.data+right.data < target){
                left = In(leftStk);
            }else if(left.data + right.data > target){
                right = reverseIn(rightStk);
            }else if(left.data + right.data == target){
                System.out.println(left.data+" "+right.data);
                left = In(leftStk);
                right = reverseIn(rightStk);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        node root = construct(arr, 0, arr.length-1);
        display(root);
        target1(root, root, 12);
        System.out.println("********");
        array = new ArrayList<>();
        inorder(root);
        target2(array, 12);
        System.out.println("**********");
        targetBest(root, 12);
    }
}
