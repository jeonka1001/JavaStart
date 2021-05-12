import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Clinet {
	public static void main(String[] args) {
		Socket sock = null;
		BufferedReader cin = null;
		PrintWriter sout = null;
		BufferedReader sin = null;
		
		try {
			sock = new Socket("127.0.0.1",9000); // 접속할 서버 주소 , 포트번호
			System.out.println("127.0.0.1 서버에 접속 완료.");
			
			cin = new BufferedReader(new InputStreamReader(System.in));
			sin = new BufferedReader(new InputStreamReader(sock.getInputStream()));//접속할 서버의 인풋 스트
			sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())));
			
			while(true) {
				System.out.println("전송 메시지 : ");
				String str = cin.readLine();
				sout.println(str);
				sout.flush();
				String reply = sin.readLine();
				System.out.println("회신 메시지는 :" + reply);
				if(reply.toUpperCase().equals("BYE")) {
					break;
				}
			}
		}catch(Exception e) {}
		finally {
			try {
				sock.close();
			}catch(Exception e) {}
		}
	}
}
