import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;
class levelOrderLinewise2{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){

        }
        Node(int data){
            this.data = data;
        }
    }

    public static Node constructor(int[] arr){
        Node root = new Node();
        Stack<Node> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node temp =new Node();
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

    public static void levelOrderLinewise2(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(new Node(-1));

        while(mq.size()>0){
            node = mq.remove();
            if(node.data != -1){
                System.out.print(node.data + " ");
                for(Node child: node.children){
                    mq.add(child);
                }
            }else{
                if(mq.size()>0){
                    mq.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args){
       int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

       Node root = constructor(arr);
       levelOrderLinewise2(root);
       System.out.println();

    }
}