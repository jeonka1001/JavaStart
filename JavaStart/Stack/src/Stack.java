
public class Stack {
	private IntBox members;
	private int top;
	
	public Stack() {
		members=null;
		top=0;
	}
	public void push(int value) {
		members = new IntBox(value,members);
		top++;
	}
	public int pop() {
		int redata = members.getData();
		
//		members.setData(members.getNextBox().getData());
//		members.setNextBox(members.getNextBox().getNextBox());
		
		members=members.getNextBox();
		top--;
		return redata;
	}
	public int getSize() {
		return top;
	}
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}
}
