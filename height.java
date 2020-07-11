import java.util.*;

class height{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int height(Node node){
        int ht = -1;

        for(Node child: node.children){
            int ch = height(child);
            ht = Math.max(ch, ht);
        }

        ht += 1;
        return ht;
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int val: arr){
            if(val == -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = val;
                if(st.size()>0){
                    st.peek().children.add(t);
                }else{
                    root = t;
                }
                st.push(t);
            }
        } System.out.println(height(root));
    }
}