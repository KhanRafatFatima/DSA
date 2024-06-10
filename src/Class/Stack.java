package Class;

public class Stack {
    Node top;
    int height;

     class Node{
         int value;
         Node next;
         public Node(int value){
             this.value=value;
         }
     }
     public Stack(int value){
         Node newNode=new Node(value);
         top=newNode;
         height =1;
     }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

        public void push(int value) {
            Node newNode = new Node(value);
            if (height == 0) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            height++;
        }

        public Node pop(){
         if(height==0) return null;
         Node temp=top;
         top=top.next;
         temp.next=null;
         height--;
         return temp;


        }

    }





