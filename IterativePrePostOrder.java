import java.util.Stack;
import java.util.ArrayList;
class IterativePrePostOrder{

    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node constructor(int[] arr){
        Stack<Node> st = new Stack<>();
        Node root = new Node();

        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = arr[i];

                if(st.size() > 0){
                    st.peek().children.add(t);
                }else{
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }

    public static void solution(Node node){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));

        String pre = "";
        String post = ""; 
        while(st.size() > 0){
            Pair p = st.peek();
            if(p.state == -1){
                pre += " " + p.node.data;
                p.state++;
            }else if(p.state == p.node.children.size()){
                post += " " + p.node.data;
                st.pop();
            }else{
                Pair child = new Pair(p.node.children.get(p.state), -1);
                st.push(child);
                p.state++;
            }
        }

        System.out.println("pre: " + pre);
        System.out.println("post: " + post);
    }

    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructor(arr);

        solution(root);
    }
}
