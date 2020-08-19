import java.util.ArrayList;
import java.util.Stack;
class areTreesMirrorInShape{

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

    public static boolean areMirror(Node n1, Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i=0; i<n1.children.size(); i++){
            int j = n1.children.size()-1-i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);

            if(areMirror(c1, c2) == false){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        boolean ans = areMirror(root, root);
        System.out.println(ans);
    }
}