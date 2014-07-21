package com.lzy.ch2;

public class q6 {

	/**
2.6
Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
EXAMPLE
Input:A ->B->C->D->E-> C[thesameCasearlier] 
Output:C


书上很经典的解法，一般list中取一个点，普遍会想到采用快慢指针的概念。
龟兔赛跑
Proof:
K -- number of nodes before cycle start point in list
C -- number of nodes of cycle
Let the faster nodes forward 2 steps each turn, slow nodes forward 1 step each turn.
S -- how many steps slow node passed when two nodes meet.
X -- the node distance between the meet point and cycle start point

When two meet each other, lets say first nodes go through whole cycle M times, second nodes go through whole cycle N times, we have:

equation 1 => S = K + M *C + X
eq 2 => 2S = K + N * C + X

eq 2 - eq 1 => S  = (N - M) * C
Replace S in eq 1 => X = (N - M)C - K - M = (N - 2M)C - K

So at their meeting point, after K more steps the slower node will arrive the cycle start.
Inorder to do that we just need to put the fast node back to head and go one step forward each time, as well as slow node, until they meet each other again in the cycle start point

	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n =new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(0);
		n.appendToTail(4);
		Node p=n;
		while(p.next!=null)
			p=p.next;
		p.next=n.next.next;
		Node head1=getCircularHead(n);
		Node head2=findCircleStart(n);
	}
	//method 1: time O(n^2) space O(1)
	public static Node getCircularHead(Node n)
	{
		Node f=n;
		Node s=n;
		int fcnt=1;
		int scnt=1;
		while(true)
		{
			f=f.next;
			fcnt++;
			while(f!=s)
			{
				s=s.next;
				scnt++;
			}
			if(scnt!=fcnt)
			{
				System.out.println(s.data);
				return s;
			}
			s=n;
			scnt=1;
		}
	}
	//method 2: in book  time o(n) space o(1)
	public static Node findCircleStart(Node n)
	{
		Node fast=n;
		Node slow=n;
		while(true)
		{
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				break;
		}
		fast=n;
		while(fast!=slow)
		{
			//after k step they will meet
			fast=fast.next;
			slow=slow.next;
		}
		System.out.println(slow.data);
		return slow;
		
	}
}

class Node {
	Node next = null;
	int data;
	public Node(int d) {
		data = d;
	}
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public String toString() {
		Node n = this;
		String str = "";
		while (n.next != null) {
			str += String.valueOf(n.data) + "->";
			n = n.next;
		}
		// The last node
		str += String.valueOf(n.data) + "->null";
		return str;
	}
}
