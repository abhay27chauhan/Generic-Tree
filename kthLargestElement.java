import java.util.Stack;
import java.util.ArrayList;
class kthLargestElement{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node constructor(int[] arr){
        Node root = new Node();
        Stack<Node> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node temp = new Node();
                temp.data = arr[i];
                if(st.size()>0){
                    st.peek().children.add(temp);
                }else{
                    root = temp;
                }
                st.push(temp);
            }
        }
        return root;
    }

    static int floor;
    public static void floorCeil(Node node, int data){

        if(node.data<data){
            if(node.data>floor){
                floor = node.data;
            }
        }

        for(Node child: node.children){
            floorCeil(child, data);
        }
    }

    
    public static int kthLargestElement(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for(int i=0; i<k; i++){
            floorCeil(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        int kthLargest = kthLargestElement(root, 3);
        System.out.println(kthLargest);
    }
}