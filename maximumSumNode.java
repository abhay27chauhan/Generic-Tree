import java.util.ArrayList;
import java.util.Stack;
class maximumSumNode{

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

    static int msn = 0;
    static int ms = Integer.MIN_VALUE;
    public static int solution(Node node){
        int sum = 0;

        for(Node child: node.children){
            int cs = solution(child);
            sum = sum+cs;
        }

        sum += node.data;

        if(sum > ms){
            ms = sum;
            msn = node.data;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] arr = {10,20,-50,-1,-60,-1,-1,30,-70,-1,80,-110,-1,120,-1,-1,90,-1,-1,40,-100,-1,-1,-1};
        Node root = constructor(arr);
        solution(root);
        System.out.println(msn + " " + ms);
    }
}
