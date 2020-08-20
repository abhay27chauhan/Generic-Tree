import java.util.ArrayList;
import java.util.Stack;
class ceilAndFloor{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node constructor(int[] arr){
        Node root = new Node();
        Stack<Node> st = new Stack<>();

        for(int i=0 ;i<arr.length; i++){
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

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data){

        if(node.data>= data){
            if(node.data<ceil){
                ceil = node.data;
            }
        }

        if(node.data<= data){
            if(node.data>floor){
                floor = node.data;
            }
        }

        for(Node child: node.children){
            ceilAndFloor(child, data);
        }
    }

    public static void main(String[] args){
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = constructor(arr);

        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;

        ceilAndFloor(root, 75);

        System.out.println("ceil : " + ceil);
        System.out.println("floor : " + floor);
    }
}