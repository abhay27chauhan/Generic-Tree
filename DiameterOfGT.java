import java.util.Stack;
import java.util.ArrayList;
class DiameterOfGT{

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

    static int dia = 0;
    public static int diameter(Node node){
        int dn = -1;
        int sdn = -1;

        for(Node child: node.children){
            int ch = diameter(child);

            if(ch > dn){
                sdn = dn;
                dn = ch;
            }else if(ch > sdn){
                sdn = ch;
            }
        }

        int cand = sdn + dn + 2;
        if(cand > dia){
            dia = cand;
        }

        dn += 1;

        return dn;
    }

    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructor(arr);
        diameter(root);
        System.out.println(dia);
    }
}
