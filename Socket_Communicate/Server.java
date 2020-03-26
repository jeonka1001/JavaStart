import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket sSock = null;
		BufferedReader cin = null;// 콘솔 입력
		BufferedReader sin = null;//소켓입력
		PrintWriter sout = null;//소켓출력
		//printWriter = 문자열 단위 => println을 위해서 사용한다. 
		// bufferedWriter = 문자 단위
		
		try {
			sSock = new ServerSocket(9000); // 포트번호를 정하고 바인딩을 하기 위함
			System.out.println("9000포트로 클라이언트를 대기중입니다.");
			
			cin = new BufferedReader(
					new InputStreamReader(System.in)); // 콘솔에 입력하기 위함
			
			Socket cSock = sSock.accept();	// 서버소켓에허가받 소켓을 저장한다.
			
			InetAddress client = cSock.getInetAddress(); //허가받은 소켓의 주소를 클라이트로 정의
			
			System.out.println(client.getHostName()+" 가 연결되었습니다.");
			
			sin = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cSock.getOutputStream())));
			while(true) {
				String str = sin.readLine();// 상대방이 보낸 소켓버퍼 내 데이터를 읽어서 저장
				System.out.println("회신메시지"+str); // 후 출력
				if(str.toUpperCase().equals("BYE")) {
					break;
				}
				System.out.print("전송 메시지 : "); 
				String sendStr =  cin.readLine();//콘솔에서 읽어들인다
				sout.println(sendStr);
				sout.flush();
				
			}
		}catch (Exception e) {}
		finally {
			try {
				sSock.close();
			}catch(Exception e) {}
		}
	}
}
