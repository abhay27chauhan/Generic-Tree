import java.util.ArrayList;
import java.util.Stack;
class distBwNodes{

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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list; 
        }

        for(Node child: node.children){
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if(ptc.size()>0){
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int distBwNodes(Node node, int d1, int d2){
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);

        int i= path1.size()-1; 
        int j= path2.size()-1;

        while(i>=0 && j>=0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        i++; j++;
        
        return i+j;
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);
        int dist = distBwNodes(root, 70, 110);
        System.out.println(dist);

    }
}