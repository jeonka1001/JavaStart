import java.util.List;

public class User implements Runnable{
	private String name;
	FileObject fobj;
	public User(FileObject fobj,String name) {
		this.fobj = fobj;
		this.name=name;
	}
	
	public void run() {
		
		while(true) {
			
			try {
				List<Object> obj = fobj.getObject();				
				for(Object o : obj) {
					System.out.print(name+"님의 출력 :"+ o + " ");
				}
				System.out.println();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {}
		}
	}
}
