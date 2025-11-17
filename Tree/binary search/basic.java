public class basic {
    public static class node{
        int data;
        node left;
        node right;
        node(int data,node left,node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        node(){}
    }
    public static node construct(int[] arr,int low,int high){
        if(low > high){
            return null;
        }
        int mid =  (low+high)/2;
        int data = arr[mid];
        node left = construct(arr, low, mid-1);
        node right = construct(arr, mid+1, high);
        return new node(data,left,right);
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
    public static int size(node node){
        if(node == null){
            return 0;
        }
        int left = size(node.left);
        int right = size(node.right);
        int size = left+right+1;
        return size;
    }
    public static int sum(node node){
        if(node == null){
            return 0;
        }
        int leftsum = sum(node.left);
        int rightsum = sum(node.right);
        return leftsum+rightsum+node.data;
    }
    public static int max(node node){
        int max = Integer.MIN_VALUE;
        while(node.right != null){
           max = node.data;
           node = node.right;
        }
        return max;
    }
    public static int maxRe(node node){
        if(node.right != null){
            return maxRe(node.right)
        }
        else{
            return node.data;
        }
    }
    public static boolean isthere(node node,int data){
        if(node == null){
            return false;
        }
        if(node.data>data){
           return isthere(node.left, data);
        }else if(node.data == data){
            return true;
        }else{
            return isthere(node.right, data);
        }
    }
    public static int min(node node){
        int min  = Integer.MAX_VALUE;
        while(node.left != null){
            min = node.data;
            node = node.left;
        }
        return min;
    }
    public static node removeNode(node node,int data){
        if(node == null){
            System.out.println("not present");
            return null;
        }
        if(node.data>data){
            node.left = removeNode(node.left, data);
        }else if(node.data<data){
            node.right = removeNode(node.right, data);
        }else{
            if(node.left != null && node.right == null){
                return node.left;
            }else if(node.left == null && node.right != null){
                return node.right;
            }else if(node.left == null && node.right == null){
                return null;
            }else if(node.left != null && node.right != null){
                int leftmax = max(node.left);
                node.data = leftmax;
                node.left = removeNode(node.left, leftmax);
                return node;
            }

        }
        return node;
    }
    public static node addNode(node node,int data){
        if(node == null){
            return new node(data,null,null);
        }
        if(node.data>data){
           node.left =  addNode(node.left, data);
        }else if(node.data < data){
           node.right =  addNode(node.right, data);
        }else{
            System.out.println("that is already there");
        }
        return node;
    }
    public static int rSum;
    public static int sumreplace(node node){
        if(node == null){
            return rSum;
        }
        int rightSum = sumreplace(node.right);
        int temp = rSum;
        rSum += node.data;
        node.data = temp;
        
        int leftSum = sumreplace(node.left);
        return rSum;
    }
    public static void lca(node node,int data1,int data2){{
        if(node == null){
            return;
        }
        if(node.data > Math.max(data1,data2)){
            lca(node.left, data1, data2);
        }else if(node.data < Math.min(data1, data2)){
            lca(node.right, data1, data2);
        }else{
            System.out.println("lca is:"+node.data);
        }
    }}
    public static int height(node node){
        if(node == null){
            return -1;
        }
        int leftHt = height(node.left);
        int rightHt = height(node.right);
        int ht = Math.max(leftHt, rightHt)+1;
        return ht;
    }
    public static void printrange(node node,int r1, int r2){
        if(node == null)return;
        printrange(node.left, r1, r2);
        if(node.data>= r1 && node.data<=r2){
            System.out.print(node.data+" ");
        }
        printrange(node.right, r1, r2);
    }
    public static void printRange500(node node,int r1,int r2){
        if(node == null)return;
        if(node.data>= r1 && node.data<=r2){
            printRange500(node.left, r1, r2);
            if(node.data>= r1 && node.data<=r2){
                System.out.print(node.data+" ");
            }
            printRange500(node.right, r1, r2);
        }else if(node.data>r2){
            printRange500(node.left, r1, r2);
        }else if(node.data<r1){
            printRange500(node.right, r1, r2);
        }

    }

    public static void main(String[] args) {
        // int[] arr = {12,25,37,50,62,75,87,90,91};
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        node root = construct(arr1, 0, arr1.length-1);
        display(root);
        int max = max(root);
        int min = min(root);
        int ht = height(root);
        int sum = sum(root);
        int size = size(root);
        System.out.println("max:"+max+"\nmin:"+min+"\nht:"+ht+"\nsum:"+sum+"\nsize:"+size);
        System.out.println(isthere(root,95)?"present":"haha good one");
        // addNode(root, 42);
        // display(root);
        // removeNode(root, 42);
        // display(root);
        rSum = 0;
        // sumreplace(root);
        // display(root);
        lca(root, 3, 1);
        printrange(root, 3, 8);
        System.out.println();
        printRange500(root, 3, 8);
    }
}
