import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class traversal {
    public static class node{
        int data;
        ArrayList<node> children = new ArrayList<>();
        node(){

        }
        node(int data){
            this.data = data;
        }
    }
    static void display(node node){
        String str = node.data+" -> ";
        for (node bacha : node.children) {
            str+= bacha.data+" ,";
        }
        System.out.println(str);
        for (node child : node.children) {
            display(child);
        }
    }
    static void traversal(node node){
        System.out.println("node pre-> " + node.data);
        for (node child : node.children) {
            System.out.println("edge pre->"+ node.data+"--"+child.data);
            traversal(child);
            System.out.println("edge post->"+node.data+"--"+child.data);
        }
        System.out.println("node post->"+node.data);
    }
    static void levelTraversal(node node){
        Queue<node> q = new ArrayDeque<>();
        q.add(node);
        while(!q.isEmpty()){
            node a = q.remove();
            System.out.println(a.data);
            for (node child : a.children) {
                q.add(child);
            }
        }
    }
    static void levelTraversal2(node node){
        Queue<node> main = new ArrayDeque<>();
        Queue<node> helper  = new ArrayDeque<>();
        main.add(node);
        while (!main.isEmpty()) {
            node = main.remove();
            System.out.print(node.data+"\t");
            for (node child : node.children) {
                helper.add(child);
            }
            if(main.isEmpty()){
                System.out.println();
                main = helper;
                helper = new ArrayDeque<>();
            }
            
        }
    }
    static void levelTraversalPointer(node node) {//IN TREE WE CAN'T ADD NULL SO MADE A CONSTRUCTOR TO RUN THIS APPROACH
        Queue<node> q = new ArrayDeque<>();
        q.add(node);
        
        q.add(new node(-1)); // level marker

        while (!q.isEmpty()) {
            node temp = q.remove();
            if(temp.data != -1){
                System.out.print(temp.data+"\t");
                for (node child : temp.children) {
                    q.add(child);
                }
            }else{
                System.out.println();
                if(q.size()>0){
                    q.add(new node(-1));
                }
            }
            // if (temp == null) {
            //     System.out.println();
            //     if (q.size() > 0) {
            //         q.add(null); 
            //     }
            // } else {
            //     System.out.print(temp.data + " "); 
            //     for (node child : temp.children){
            //         q.add(child);
            //     }
            // }
        }
    }

    static void levelTraversal3(node node){
        Stack<node>main = new Stack<>();
        Stack<node>helper = new Stack<>();
        main.add(node);
        int level = 1;
        while(!main.isEmpty()){
            node = main.pop();
            System.out.print(node.data+"\t");
            if(level %2 !=0){
                for (node child : node.children) {
                    helper.add(child);
                }
            }else{
                for (int i = node.children.size()-1; i >=0; i--) {
                    helper.push(node.children.get(i));
                }
            }
            if(main.isEmpty()){
                main = helper;
                helper = new Stack<>();
                System.out.println();
                level++;
            }
        }
        
    }
    static void levelTraversalSize(node node){
        Queue<node> q = new ArrayDeque<>();
        q.add(node);
        
        while(!q.isEmpty()){
            for (int i = 0; i < q.size(); i++) {
                node = q.remove();
                System.out.print(node.data+"\t");
                for (node child : node.children) {
                    q.add(child);
                }
            }
            System.out.println();
        }
    }
    // pair type level order execution
    private static class pair {
        node node;
        int level;
        pair(node node,int data){
            this.node = node;
            this.level = data;
        }
    }
    static void levelTraversalPair(node node){
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(node, 1));
        int level = 1;//same as level var in pair alias data
        while (!q.isEmpty()) {
            pair p = q.remove();
            if(p.level > level){
                level = p.level;
                System.out.println();
            }
            System.out.print(p.node.data+"\t");
            for (node child : p.node.children) {
                q.add(new pair(child, p.level+1));//in pair why level var is not added here as it doesnot get updated as if loop will only update if greater is added in the queue
            }
        }
    }
    public static void main(String[] args) {
        node root = null;
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,100,-1,-1,80,110,-1,-1,-1,40,90,-1,-1,-1,};
        Stack<node> stk = new Stack<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i] ==-1){stk.pop();}
            else{node curr = new node();
            curr.data = arr[i];
            if(stk.size() == 0){
                stk.push(curr);
                root = curr;
            }else{
                stk.peek().children.add(curr);
                stk.push(curr);
            }}
        }
        display(root);
        // traversal(root);
        levelTraversalPair(root);
    }
}
