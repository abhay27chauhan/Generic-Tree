import java.util.Stack;
import java.util.ArrayList;
class removeLeavesFromGT{

    public static class Node{
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

    public static void removeLeaves(Node node){
        for(int i=node.children.size()-1; i>=0; i--){
            Node child = node.children.get(i);

            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }

        for(Node child: node.children){
            removeLeaves(child);
        }
    }

    public static void display(Node node){
        String str = node.data + " -> ";
        for(Node child: node.children){
            str += child.data + ", ";
        }

        str += ".";
        System.out.println(str);
        for(Node child: node.children){
            display(child);
        }
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        removeLeaves(root);
        display(root);
    }
}