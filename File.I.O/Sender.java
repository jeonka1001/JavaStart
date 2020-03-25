import java.util.Random;

public class Sender implements Runnable{
	private FileObject fobj;
	private String name;
	
	public Sender(FileObject fobj, String name) {
		this.fobj = fobj;
		this.name=name;
	}
	public void run() {
		Random rand = new Random();
		while(true) {
			int r = rand.nextInt();
			try {
				fobj.saveObject(r);
				System.out.println(name+" 님이 파일에 기록하였습니다.");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
	}
}
