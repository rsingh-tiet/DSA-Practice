// ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
// ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░   ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
// ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
// ▒▒     ▒▒▒▒▒▒   ▒▒▒▒▒   ▒   ▒▒▒▒▒▒   ▒▒▒▒▒  ▒    ▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒    ▒  ▒  ▒    ▒▒▒▒   ▒▒▒▒▒▒▒▒   ▒▒▒▒
// ▓   ▓▓   ▓▓  ▓▓▓   ▓▓▓   ▓▓   ▓▓  ▓▓▓   ▓▓▓   ▓▓▓▓   ▓▓   ▓▓▓▓▓▓▓▓▓▓▓▓   ▓▓▓▓   ▓▓▓▓▓  ▓▓▓   ▓▓▓  ▓▓▓   ▓
// ▓  ▓▓▓   ▓         ▓▓▓   ▓▓   ▓         ▓▓▓   ▓▓▓▓   ▓   ▓▓▓▓▓▓▓▓▓▓▓▓▓   ▓▓▓▓   ▓▓▓▓         ▓▓         ▓
// ▓    ▓   ▓  ▓▓▓▓▓▓▓▓▓▓   ▓▓   ▓  ▓▓▓▓▓▓▓▓▓▓   ▓▓▓▓   ▓▓   ▓▓▓▓▓▓▓▓▓▓▓▓   ▓ ▓▓   ▓▓▓▓  ▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓
// █████   ████     ████    ██   ███     ████    ████   ████    ██████████   ██    ██████     ██████     ███
// ███    ██████████████████████████████████████████████████████████████████████████████████████████████████
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class genBasic {
    private static class node{
        int data;
        ArrayList<node> children = new ArrayList<>();
    }
    public static int size (node n){
        int size = 0;
        for (node child :n.children) {
            if(child.data>0){
                size+= size(child);
            }
        }
        size+=1;
        return size;
    }
    public static void display(node node){
        String str = node.data +"->";
        for (node child :node.children) {
            str+= child.data+" ";
        }
        str+= ".";
        System.out.println(str);
        for (node child : node.children) {
            display(child);
        }

    }
    public static int max(node node){
        int max = Integer.MIN_VALUE;
        for (node child:node.children) {
            int childMax = max(child);
             max = Math.max(childMax,max);
        }
        max = Math.max(max, node.data);
        return max;
    }
    static int min(node node){
        int min = Integer.MAX_VALUE;
        for(node child:node.children){
            int ChildMin = min(child);
            min = Math.min(ChildMin, min);
        }
        min = Math.min(min, node.data);
        return min;
    }
    static int height(node node){
        int ht = -1;
        for(node child : node.children){
            int childHt = height(child);
            ht = Math.max(childHt, ht);
        }
        ht = ht+1;
        return ht;
    }
    static void mirror(node node){
        for (node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }
    static void removeLeaf(node node){
        for(int i = node.children.size()-1;i>=0;i--){
            node child  = node.children.get(i);
            if(child.children.size() ==0){
                node.children.remove(i);
            }
        }
        for (node child : node.children) {
            removeLeaf(child);
        }
    }
    static boolean hasElement(node node,int d){
        if(node.data == d){
            return true;
        }
        for (node child : node.children) {
           boolean curr =  hasElement(child, d);
            if(curr == true){
                return true;
            }
        }
        return false;
    }
    static String path(node node , int d){
        if(node.data == d){
            String str = new String();
            str+= node.data+"-";
            return str;
        }
        for (node child : node.children) {
            String curr = path(child, d);
            if(curr.length()>0){
                curr += "-"+node.data;
                return curr;
            }
        }
        return new String();
    }
    
    public static ArrayList<node> rootpath(node node ,int d){
        if (node.data == d) {
            ArrayList<node> arr = new ArrayList<>();
            arr.add(node);
        }
        for (node child : node.children) {
            ArrayList<node> curr = rootpath(child, d);
            if(curr.size()>0){
                curr.add(child);
            }
        }
        return new ArrayList<>();
    }
public static int distanceBtw(node root, int d1, int d2) {
    ArrayList<Integer> path1 = nodeToRootPath(root, d1);
    ArrayList<Integer> path2 = nodeToRootPath(root, d2);

    int i = path1.size() - 1;
    int j = path2.size() - 1;

    // Move from root side until paths diverge
    while (i >= 0 && j >= 0 && path1.get(i).equals(path2.get(j))) {
        i--;
        j--;
    }
    i++;
    j++;

    // distance = nodes after LCA in both paths
    int distance = i + j;
    return distance;
}

    public static ArrayList<Integer> nodeToRootPath(node node, int data) {
    if (node.data == data) {
        ArrayList<Integer> path = new ArrayList<>();
        path.add(node.data);
        return path;
    }
    for (node child : node.children) {
        ArrayList<Integer> childPath = nodeToRootPath(child, data);
        if (childPath.size() > 0) {
            childPath.add(node.data);
            return childPath;
        }
    }
    return new ArrayList<>();
}
    public static int lca(node root, node n1,node n2){
        ArrayList<node> arr1 = rootpath(root,n1.data);
        ArrayList<node> arr2 = rootpath(root, n2.data);
        int i = arr1.size()-1,j = arr2.size()-1;
        while((i>=0 &&j>=0)&& arr1.get(i).data == arr2.get(j).data){
            i--;j--;
        }
        i++;j++;
        return arr1.get(i).data;
    }
    private static node gettail(node node){
        while(node.children.size()==1){
            node = node.children.get(0);
        }
        return node;
    }
    static void linearTree(node node){
        for (node child : node.children) {
            linearTree(child);
        }
        while(node.children.size()>1){
            node last = node.children.remove(node.children.size()-1);
            node secondLast = node.children.get(node.children.size()-1);
            node tail = gettail(secondLast);
            tail.children.add(last);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        node root = null;
        // System.out.println("enter size for array to be processed for tree");
        // int a = scn.nextInt();
        // int[] arr = new int[a];
        // for (int i = 0; i < a; i++) {
        //     arr[i] = scn.nextInt();
        // }
        // 

        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1,};
    //    int[] arr = {
    //         1,          // root
    //         2, 5, -1,   // children of root
    //         3, 6, -1, -1, // child 3 has child 6
    //         4, 7, 8, -1, -1, -1, // child 4 has children 7 and 8
    //         9, -1,      // child of 7
    //         10, -1,     // child of 9
    //         11, -1,     // child of 10 → longest path
    //         -1, -1      // closing remaining
    //     };
        
        // int[] arr = {10,20,-1,-1};
        Stack<node> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == -1){
                stk.pop();
            }else{
                node curr = new node();
                curr.data = arr[i];
                if(stk.size() == 0){
                    root = curr;
                }else{
                    stk.peek().children.add(curr);
                }
                stk.push(curr);
            }
        }
        display(root);
        int size = size(root);
        System.out.println(size);
        int maxTree = max(root);
        System.out.println("max : "+maxTree);
        int min = min(root);
        System.out.println("min :"+min);
        int ht = height(root);
        System.out.println("ht :"+ht);
        // mirror(root);
        // display(root);
        // removeLeaf(root);
        // linearTree(root);
        // display(root);
        // boolean ans = hasElement(root, 120);
        // System.out.println(ans);
        // String ans1 = path(root, 120);
        // System.out.println(ans1);
        int distance = distanceBtw(root, 100, maxTree);
        System.out.println(distance);

        
    }
}
