import java.util.ArrayList;
import java.util.Stack;
class preNSucc{

     private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node constructor(int[] arr){
        Node root = new Node();
        Stack<Node> st = new Stack<>();

        for(int i=0 ;i<arr.length; i++){
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

    static Node predecessor;
    static Node successor;
    static int state;

    public static void preNSucc(Node node, int data){

        if(state == 0){
            if(node.data == data){
                state = 1;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
            successor = node;
            state = 2;
        }

        for(Node child: node.children){
            preNSucc(child, data);
        }
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        predecessor = null;
        successor = null;
        state = 0;

        preNSucc(root, 90);
        
        System.out.println("predecessor : " + predecessor.data);
        System.out.println("successor : " + successor.data);
    }
}