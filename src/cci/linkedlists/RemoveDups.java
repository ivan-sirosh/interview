package cci.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

  static List removeDups(List list){

    Set<Character> buffer = new HashSet<>();
  

    Node n = list.head;

    while (n != null) {
      if(buffer.contains(n.data)){

      } else {
        
      }
      
    }
    

    return list;
  }

  static class Node {
    Node next = null;
    char data;

    Node(char data) {
      this.data = data;
    }

    Node(char data, Node next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return "'" + data + "' -> " + next;
    }
  }

  static class List {
    Node head;
    Node tail;
    int size = 0;

    Node append(Node node){
      if(size == 0){
        head = node;
        tail = node;
        size++;
      } else {
        tail.next = node;
        tail = node;
      }

      size++;

      return tail;
    }

    @Override
    public String toString(){
      return "[" + head + "]";
    }
  }

  public static void main(String[] args) {

    List list = new List();

    for(char c: "FOLLOW UP".toCharArray()){
        list.append(new Node(c));
    }

    System.out.println(removeDups(list));
  }
}
