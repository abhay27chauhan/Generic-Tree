import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
class levelOrderLinewise4{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state= state;
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

    public static void levelOrderLinewise4(Node node){
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(node, 1));
        int state = 1;
        while(mq.size()>0){
            Pair p = mq.remove();

            if(p.state> state){
                state = p.state;
                System.out.println();
            }

            System.out.print(p.node.data + " ");

            for(Node child: p.node.children){
                mq.add(new Pair(child, p.state+1));
            }
        }
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        levelOrderLinewise4(root);
        System.out.println();
    }
}