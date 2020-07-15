import java.util.*;
class Traversal{

    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void traversal(Node node){
        System.out.println("Node Pre: " + node.data);

        for(Node child: node.children){
            System.out.println("Edge Pre: " + node.data + " --- " +child.data);
            traversal(child);
            System.out.println("Edge Post: " + child.data + " --- " +node.data);
        }
        System.out.println("Node Post: " + node.data);
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = null;
        Stack<Node> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = arr[i];
                if(st.size()>0){
                    st.peek().children.add(t);
                }else{
                    root = t;
                }
                st.push(t);
            }
        } traversal(root);
    }
}



/*  Pre Order ->1. Node's Left side - euler path
                2. Before going deep in recursion
                3. Node is visited before child
                4. root is first
                5. before call

    Pre Order ->1. Node's right side - euler path
                2. coming out of recursion
                3. child is visited after Node
                4. root is last 
                5. after call
*/