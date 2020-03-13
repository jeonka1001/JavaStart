
public class IntBox {
	private int data;
	private IntBox nextBox;
	
	public IntBox(int data,IntBox nextBox) {
		this.data = data;
		this.nextBox = nextBox;
	}
	public void setNextBox(IntBox nextBox) {
		this.nextBox = nextBox; 
	}
	public void setData (int data) {
		this.data = data;
	}
	public IntBox getNextBox() {
		return nextBox;
	}
	public int getData() {
		return data;
	}
	
	
}
