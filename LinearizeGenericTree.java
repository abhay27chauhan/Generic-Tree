import java.util.Stack;
import java.util.ArrayList;
class LinearizeGenericTree{
    
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

    public static void Linearize(Node node){
        for(Node child: node.children){
            Linearize(child);
        }

        while(node.children.size()>1){
            Node lc = node.children.remove(node.children.size()-1);
            Node sl = node.children.get(node.children.size()-1);
            Node slt = getTail(sl);
            slt.children.add(lc);
        }
    }

    private static Node getTail(Node node){
            while(node.children.size() == 1){
                node = node.children.get(0);
            }

            return node;
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
        Linearize(root);
        display(root);
    }
}