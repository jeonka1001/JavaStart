import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class FileObject {
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private String fileName;
	public FileObject(String fileName){
		this.fileName = fileName;
		in = null;
		out =null;
	}
	private void closeInput() {
		try {
			in.close();
			in = null;
		}catch(IOException e){}
	}
	
	private void closeOutput() {
		try {
			out.close();
			out =null;
		}catch(IOException e) {}
	}
	
	private void createInput(String fileName) {
		try {
		this.in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(fileName)));
		}catch(FileNotFoundException e) {}
		catch(IOException e) {}
	}
	
	private void createOutput(String fileName) {
		try {
		this.out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(fileName)));
		}catch(FileNotFoundException e) {}
		catch(IOException e) {}
	}
	
	public synchronized void saveObject(Object obj)throws Exception
	{
		//입력 스트림 소.(조건 : 입력 스트림 존재할 경우)
		//출력 스트림 생성 ( 조건 : 출력 스트림이 존재하지 않을 경우)
		if(in !=null) {
			System.out.println("인풋 소멸");
			this.closeInput();
		}
		if(out == null) {
			System.out.println("아웃풋 생성");
			this.createOutput(fileName);
		}
		out.writeObject(obj);
		out.flush();
	}
	
	public List<Object> getObject()throws Exception
	{
		
		//출력 스트림 닫기 : 출력 스트림이 존재한 경우
		// 입력 스트림 취득 생성 (조건 : 입력 스트림이 존재하지 않을 경우)
		LinkedList<Object> list = new LinkedList<>();
		synchronized(this) {
			if(out != null) {
				System.out.println("아웃풋 소멸");
				this.closeOutput();
			}
			if(in == null) {
				System.out.println("인풋 생성");
				this.createInput(fileName);
			}
		
		
			while(true) {
				try {
					Object obj = in.readObject();
					
					list.addLast(obj);
				}catch(EOFException e) {break;}	
			}
		}
		return list;
	}
	
	
}
