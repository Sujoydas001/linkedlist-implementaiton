import java.util.HashSet;
import java.util.Stack;

class Node{ 
    int data ; 
    Node next ; 
}

public class linkedlist {
    public Node create(int data){
        Node newnode = new Node(); 
        newnode.data = data; 
        newnode.next = null ; 
        System.out.println("first node created");
        return newnode ; 

    }
    public int size(Node head){
        Node temp = head ; 
        int size = 0 ; 
        while( temp != null ){
            temp = temp.next ; 
            size++ ; 
        }
        return size ; 
    }
    public Node setElement( Node head , int idx , int data){
        if ( idx >= 0 && idx <= size(head)){
            
            Node newnode = new Node(); 
            if ( head == null ){
                head = create(data);
            }else if ( idx == 0 ){
                newnode.data = data; 
                newnode.next = head ; 
                head = newnode ;
            }else {
                Node temp = head ; 
                Node prev = head ; 
                int i = 0 ; 
                while( i < idx - 1 && temp.next != null ){
                    temp = temp.next ; 
                    prev = prev.next ; 
                    i++ ; 
                };
                temp = temp.next ; 
                newnode.data = data ; 
                newnode.next = temp ; 
                prev.next = newnode ;
            }
        }else {
            System.out.println("out of index");
        };
        return head ; 
    } 
    public Node insertlast(Node head , int data){
        Node newnode = new Node(); 
        if ( head == null ){
            head = create(data);
        }else{
            Node temp = head ; 
            while( temp.next != null ){
                temp = temp.next ; 
            };
            newnode.data = data ; 
            newnode.next = null ; 
            temp.next = newnode ;
        }
        return head ; 
    }
    public Node insertfirst(Node head , int data){
        Node newnode = new Node(); 
        if ( head == null ){ 
            head = create(data);            
        }else {
            newnode.data = data;
            System.out.println("node created");
            newnode.next = head ; 
            head = newnode ;
        }
        return head ; 
    };
    public void printlist(Node head){
        Node temp = head ; 
        while ( temp != null  ){
            System.out.print(temp.data + " -> " );
            temp = temp.next ; 
        }
        System.out.println();
    }
    public Node deleteNode(Node head, int data){
        Node temp = head ; 
        if ( temp == null ){
            System.out.println("nothing");
            return head ; 
        }
        if ( temp.data == data ){
            head = temp.next ;
            return head ; 
        }else{
            while ( temp.next.data != data && temp.next.next != null) {
                    temp = temp.next ; 
            }
            if ( temp.next.data == data ){
                temp.next = temp.next.next ;
            };
        
        }; 
        
        return head ; 
    }
    public boolean contains(Node head , int data){
        Node temp = head ; 
        while ( temp != null ){
            if ( temp.data == data ){
                return true ; 
            }
            temp = temp.next ; 
        };
        return false ; 
    }
    public int middle( Node head ){
        Node fast , slow ; 
        fast = head ; 
        slow = head ; 
        while ( fast != null && fast.next != null ){
            fast = fast.next.next ; 
            slow = slow.next ; 
        };
        return slow.data ; 
    }
    public int countno(Node head , int data ){
        int count = 0 ; 
        Node temp = head ; 
        while ( temp != null ){
            if ( temp.data == data ){
                count ++ ; 
            }
            temp = temp.next ; 
        }
        return count ; 
    }
    public boolean ispallindrome(Node head ){
        Node temp = head ; 
        Stack<Integer> st = new Stack<>(); 
        int len = size(head) ; 
        int i = 0 ; 
        while ( i < len / 2 ){
            st.push( temp.data);
            temp = temp.next ; 
            i++;
        };
        if ( len % 2 == 1 ){
            temp = temp.next ; 
        }
        while ( temp != null ){
            if ( temp.data != st.pop()){
                return false ; 
            };
            temp = temp.next ; 

        };
        return true ; 

    }
    public Node removeduplicate(Node head){
        Node temp = head ; 
        Node prev = null  ; 
        HashSet<Integer> hs = new HashSet<>(); 
        while ( temp != null ){
            if ( !hs.contains(temp.data)){
                hs.add(temp.data);
                prev = temp; 

            }else {
                prev.next = temp.next ; 
            }
           
            temp = temp.next ; 
        };
        return head ; 
        
    }




    public static void main(String[] args) {
        linkedlist list = new linkedlist(); 

        Node head = null ; 
        
        head = list.insertfirst(head, 12);
        head = list.insertfirst(head, 121);
        head = list.setElement(head, 1, 50);
        head = list.insertlast(head,78 );
        head = list.insertfirst(head,31);
        head = list.setElement(head,2, 15);
        head = list.insertlast(head,71 );
        list.printlist(head);
        System.out.println("middle : "+ list.middle(head));
        head = list.setElement(head, 0, 5);
        head = list.setElement(head, 3, 50);
        System.out.println(list.contains(head,121));
        head = list.deleteNode(head,121);
        head = list.insertfirst(head,12);
        head = list.insertlast(head,12);
        list.printlist(head);
        // System.out.println(list.contains(head,121));
        System.out.println("middle : "+ list.middle(head));
        System.out.println("count of " + 12 + " : "+ list.countno(head, 12));
        System.out.println("size: " + list.size(head));
        list.printlist(head);
        // System.out.println(list.ispallindrome(head));
        head = list.removeduplicate(head);
        list.printlist(head);



    }
}
