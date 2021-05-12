
public class AppStart {
	public static void main(String[] args ){
		FileObject fobj = null;
		try {
			fobj = new FileObject("/Users/jeonkyeong-an/temp/data.txt");
			new Thread(new Sender(fobj,"제공자")).start();
			new Thread(new User(fobj,"사용자")).start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
