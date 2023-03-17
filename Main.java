/*
 Purpose:To make a LinkedList class in order to create a sorrted Liked list form teo Linked list.
 Authors: Sidd Narker

 Input: Our input are two link list that are thae same size

  Output: A Linklist that have the sorted combination of two linked lists

  How to use:
  1) Enter the input file name
  2) Next the program will run and print out a LinkList
  Expected Data:
      Node data field: String
      Node next field: Node<String>
      File input: txt

  Expected Exceptions:
      FileNotFoundException

  Major Classes:
      FiveLinkedList:
           -Parent class of FiveNode
           -Fields: head: Node, ind: int
      LinkedListdemo:
           -Demo class
           -Fields: file: File, sc: Scanner, inputtext: ArrayList<String[]>, link1 link2 sorted: FiveLinkedList

 */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)
            throws FileNotFoundException {
        File fileinput = new File("C:\\Users\\sinar\\Downloads\\hw1text.txt");
        Scanner sc = new Scanner(fileinput);
        FiveLinkedList link1 = new FiveLinkedList();
        FiveLinkedList link2 = new FiveLinkedList();
        ArrayList<String[]> inputtext = new ArrayList<String[]>();

        while (sc.hasNextLine()) {
            inputtext.add(sc.nextLine().split("\\s"));
        }


        for (int i = 0; i < inputtext.size(); i++) {
            if (i == 0) {
                String[] a = (inputtext.get(i));
                for (String x : a) {
                    link1.add(x);
                }


            } else if (i == 1) {
                String[] a = (inputtext.get(i));
                for (String x : a) {
                    link2.add(x);
                }
            } else {
                System.out.println("Error: more lists than expected.");
            }

        }


        ArrayList<String> sortedA = new ArrayList<String>();
        FiveLinkedList sorted = new FiveLinkedList();

        for (int y = 0; y < 4; y++) {
            //int a = Integer.parseInt((String) link1.get(y));
            //int b = Integer.parseInt((String) link2.get(y));
            sortedA.add((String) link1.get(y));
        }
        for (int y = 0; y < 4; y++) {
            //int a = Integer.parseInt((String) link1.get(y));
            //int b = Integer.parseInt((String) link2.get(y));
            sortedA.add((String) link2.get(y));
        }

        Collections.sort(sortedA);

        FiveLinkedList link3 = new FiveLinkedList();

        for (int j = 0; j < sortedA.size(); j++) {
            String[] c = new String[]{sortedA.get(j)};
            for (String x : c)
            {
                link3.add(x);
            }


        }

        System.out.println(link1);
        System.out.println(link2);
        System.out.println(link3);


    }
}

