package com.company;
import java.util.*;
public class Main {
    public static class Node{
        int data;
        Node next;
        Node(int d, Node n){
           data = d;
           next = n;
        }
    }
    public static class LinkedList {
        int length;
        Node head;
        LinkedList(){
            head = null;
            length = 0;
        }
        void addToBeginning(int data){
            head = new Node(data, head);
            length++;
        }
        void addToEnd(int data){
            if(length < 1){
                addToBeginning(data);
                return;
            }
            Node itr = head;
            while(itr.next != null){
                itr = itr.next;
            }
            itr.next = new Node(data, null);
            length++;
        }
        void display(){
            if(length<1){
                System.out.println("NULL");
                return;
            }
            Node itr = head;
            while(itr != null) {
                System.out.print(itr.data);
                System.out.print(" --> ");
                itr = itr.next;
            }
            System.out.println("NULL");
        }
        void addFromArray(int[] data){
            for(int i = data.length - 1 ; i>=0; i--){
                addToBeginning(data[i]);
            }
        }

        void addFromArrayList(ArrayList<Integer> data){
            for(int i = data.size() - 1; i>=0; i--){
                addToBeginning(data.get(i));
            }
        }
        void insert(int data,int index){
            if(index>length - 1 || index < 0){
                throw new IndexOutOfBoundsException("Out of bounds");
            }
            else if(index == 0){
                addToBeginning(data);
            }
            else{
                Node itr = head;
                for(int i = 0; i<index-1; i++)
                    itr = itr.next;
                itr.next = new Node(data, itr.next);
            }
        }
        void remove(int index){
            if(index>length - 1 || index < 0){
                throw new IndexOutOfBoundsException("Out of bounds");
            }
            else if(index == 0){
                head = head.next;
            }
            else{
                Node itr = head;
                for(int i = 0; i<index-1; i++)
                    itr = itr.next;
                itr.next = itr.next.next;
            }
        }
        int get(int index){
            if(index>length - 1 || index < 0){
                throw new IndexOutOfBoundsException("Out of bounds");
            }
            else{
                Node itr = head;
                for(int i = 0; i<index; i++)
                    itr = itr.next;
                return itr.data;
            }
        }
        int[] toArray(){
            if(length<1){
                throw new NullPointerException("Empty List");
            }
            else {
                int[] arr = new int[length];
                Node itr = head;
                for (int i = 0; i < length; i++) {
                    arr[i] = itr.data;
                    itr = itr.next;
                }
                return arr;
            }
        }

    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int[] arr = {50,12,35,42,16,23,22,221};
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1,22,36,33,15,18,26));
        ll.addFromArrayList(arr2);
        ll.addFromArray(arr);
        ll.display();
        System.out.println(Arrays.toString(ll.toArray()));

    }

}
