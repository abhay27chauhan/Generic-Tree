import java.util.ArrayList;
import java.util.Stack;
class LinearizeGenericTreeM2{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
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

    public static Node Linearize(Node node){
        if(node.children.size() == 0){
            return node;
        }

        Node lkt = Linearize(node.children.get(node.children.size()-1));
        while(node.children.size() > 1){
            Node ln = node.children.remove(node.children.size()-1);
            Node sl = node.children.get(node.children.size()-1);
            Node slkt = Linearize(sl);
            slkt.children.add(ln);
        }

        return lkt;
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        Node lkt = Linearize(root);
        System.out.println(lkt.data);
        display(root);
    }
}