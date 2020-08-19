// travel and Change Strategy

import java.util.ArrayList;
import java.util.Stack;
class Multisolver{

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
        } return root;
    }

    static int size;
    static int max;
    static int min;
    static int height;

    public static void Multisolver(Node node, int depth){

        size++;
        max = Math.max(node.data, max);
        min = Math.min(node.data, min);
        height = Math.max(depth, height);

        for(Node child: node.children){
            Multisolver(child, depth+1);
        }

    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        size = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        height = -1;
        Multisolver(root, 0);

        System.out.println("size : " + size);
        System.out.println("max : " + max);
        System.out.println("min : " + min);
        System.out.println("height : " + height);
    }
}