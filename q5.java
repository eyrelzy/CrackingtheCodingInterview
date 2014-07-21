package com.lzy.ch2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class q5 {

	/**
2.5
You have two numbers represented by a linked list, where each 
node contains a single digit. The digits are stored in reverse order, 
such that the Ts digit is at the head of the list. Write a function 
that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
Output: 2 -> 1 -> 9.That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. 
EXAMPLE
Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
Output: 9 -> 1 -> 2.That is, 912. 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len1=5,len2=7;
		LinkedList<Integer> link1 = new LinkedList<Integer>();
		//Iterator it=ll.iterator();
		for(int i=0;i<len1;i++)
			link1.add(new Random().nextInt(10));
		LinkedList<Integer> link2 = new LinkedList<Integer>();
		//Iterator it=ll.iterator();
		for(int i=0;i<len2;i++)
			link2.add(new Random().nextInt(10));
		System.out.println(link1.toString()+"+"+link2.toString());
		addLinkedList(link1, link2,0);
		addLinkedList(link1, link2,1);
		
	}
	//O(m+n) O(max(m,n))
	public static void addLinkedList(LinkedList<Integer> link1,LinkedList<Integer> link2,int flag)
	{
		Iterator<Integer> it1;
		Iterator<Integer> it2;
		if(flag==0)
		{
			it1=link1.iterator();
			it2=link2.iterator();
		}
		else
		{
			it1=link1.descendingIterator();
			it2=link2.descendingIterator();
		}
		LinkedList<Integer> result=new LinkedList<Integer>();
		int carrier=0;
		while(it1.hasNext()&&it2.hasNext())
		{
			int sum=it1.next()+it2.next();
			int unit=(sum+carrier)%10;
			carrier=sum/10;
			result.add(unit);			
		}
		while(it1.hasNext())
		{
			if(carrier>0)
			{
				result.add(it1.next()+carrier);
				carrier=0;
			}
			else
				result.add(it1.next());
		}
		while(it2.hasNext())
		{
			if(carrier>0)
			{
				result.add(it2.next()+carrier);
				carrier=0;
			}
			else
				result.add(it2.next());
		}
		System.out.println(result.toString());
		reverseShowLinkedList(result);
	}
	public static void reverseShowLinkedList(LinkedList<Integer> result)
	{
		Iterator<Integer> it3=result.descendingIterator();
		while(it3.hasNext())
		{
			System.out.print(it3.next());
		}
		System.out.println();
	}
	
}
