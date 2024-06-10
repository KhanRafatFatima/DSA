package Class;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }

    }
    public LinkedList(int value){
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+ " ");
            temp=temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value){
     Node newNode=new Node(value);
      Node temp=head;
      if(length==0){
          head=newNode;
          tail=newNode;
      }else{
          tail.next=newNode;
          tail=newNode;
      }
      length++;
    }

    public Node removeLast(){
        if (length==0) return null;
        Node temp=head;
        Node pre=head;
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode=new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else {
            newNode.next=head;
            head = newNode;
            length++;
        }
    }

    public Node removeFirst(){
        if(length==0) return null;
        Node temp=head;
        head=head.next;
        temp.next=null;
        length--;

        if(length==0) tail=null;
        return temp;
    }

    public Node get(int index){
        if(index<0 || index>=length) return null;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        System.out.println("get---->"+temp.value);
        return temp;
    }

    public boolean set(int index,int value){
        if(index<0 || index>=length) return false;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.value=value;
        System.out.println("set---->"+temp.value);
        return true;
    }
    public boolean insert(int index,int value){
        if(index<0 || index>length) return false;
       if(length==0){
           prepend(value);
           return true;
       }
       if(length==index){
           append(value);
           return true;
       }
       Node newNode=new Node(value);
       Node temp=get(index-1);

       newNode.next=temp.next;
       temp.next=newNode;
       length++;
       return true;
    }
    public Node remove(int index){
        if(index<0 || index>=length) return null;

        if(index==0) return removeFirst();
        if(index==length-1) return removeLast();

        Node pre=get(index-1);
        Node temp=pre.next;
        pre.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }

    public void reverse(){

    }


}
