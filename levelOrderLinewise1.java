import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
class levelOrderLinewise1{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrderLinewise1(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();
        
        while(mq.size()>0){
            node = mq.remove();
            System.out.print(node.data + " ");

            for(Node child: node.children){
                cq.add(child);
            }

            if(mq.size() == 0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
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

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        levelOrderLinewise1(root);
    }
}