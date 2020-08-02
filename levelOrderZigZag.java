import java.util.ArrayList;
import java.util.Stack;
class levelOrderZigZag{

    private static class Node{
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

    public static void levelOrderzz(Node node){
        Stack<Node> ms = new Stack<>();
        ms.push(node);
        Stack<Node> cs = new Stack<>();
        int level = 0;
        while(ms.size()>0){
            node = ms.pop();
            System.out.print(node.data + " ");

            if(level%2 == 1){
                for(int i=0; i<node.children.size(); i++){
                    cs.push(node.children.get(i));
                }
            }else{
                for(int i=node.children.size()-1; i>=0; i--){
                    cs.push(node.children.get(i));
                }
            }

            if(ms.size() == 0){
                ms = cs;
                cs =new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        levelOrderzz(root);
    }
}