import java.util.Stack;
import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;
class iterableAndIterator{

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static class GenericTree implements Iterable<Integer>{
        Node root;

        public GenericTree(Node root){
            this.root = root;
        }

        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }
    }

    public static class GTPreorderIterator implements Iterator<Integer>{
        Integer nval;
        Stack<Pair> st;

        public GTPreorderIterator(Node root){
            st = new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }

        public boolean hasNext(){
            if(nval == null){
                return false;
            }else{
                return true;
            }
        }

        public Integer next(){
            Integer fr = nval;

            nval = null;
            while(st.size() > 0){
                Pair top = st.peek();
                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                }else if(top.state == top.node.children.size()){
                    st.pop();
                }else{
                    st.push(new Pair(top.node.children.get(top.state), -1));
                    top.state++;
                }   
            }

            return fr;
        }
    }

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

    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructor(arr);
        GenericTree gt = new GenericTree(root);

        Iterator<Integer> gti = gt.iterator();
        while(gti.hasNext() == true){
            System.out.print(gti.next() + " ");
        }

    }
}

/*
    Interface - contract and has only function signatures and not body.
    Any class which implements these interfaces has to honour the contract i.e. they need to define the body to each and every function signatures i.e. there in the interface.

    we cannot new the interface to make their objects rather we can new the reference of the class which is implementing that interface.
 */
