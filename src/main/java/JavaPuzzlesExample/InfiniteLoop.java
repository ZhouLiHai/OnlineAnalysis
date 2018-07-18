package JavaPuzzlesExample;


// 首先定义个链表
class SinglyLinkedList {
	private Node start;

	public void add(Integer i) {
		Node node = new Node(i);
		if (start == null) {
			start = node;
		} else {
			Node temp = start;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public Node getStart() {
		return start;
	}


	// TODO: static 内部类什么意思？需要再复习一下内部类。
	static class Node {
		private Integer value;
		private Node next;


		Node(Integer i) {
			this.value = i;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}

public class InfiniteLoop {
	public static void main(String[] args) {
		InfiniteLoop infiniteLoop = new InfiniteLoop();
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

		for (int i = 0; i < 10; i++) {
			singlyLinkedList.add(i);
		}

		System.out.println("No Loop: " + infiniteLoop.doesLoopExist(singlyLinkedList));
		System.out.println("Is Loop: " + infiniteLoop.doesLoopExist(infiniteLoop.createLoop(singlyLinkedList)));
	}

	public boolean doesLoopExist(SinglyLinkedList singlyLinkedList) {
		SinglyLinkedList.Node tortoise = singlyLinkedList.getStart();
		SinglyLinkedList.Node hare = singlyLinkedList.getStart();

		try {
			while (true) {
				/**
				 * 这个算法精妙
				 * 连个指针，一个每次走一步，一个每次走两步，如果存在环，很快就会相遇
				 * 如果不存在环，就会出现异常。
 				 */

				tortoise = tortoise.getNext();
				hare = hare.getNext().getNext();
				if(tortoise == hare)
				{
					return true;
				}
			}
		} catch (NullPointerException e) {
			return false;
		}
	}

	private SinglyLinkedList createLoop(SinglyLinkedList singlyLinkedList) {
		singlyLinkedList.getStart().getNext().getNext().getNext().setNext(singlyLinkedList.getStart().getNext());
		return singlyLinkedList;
	}
}
