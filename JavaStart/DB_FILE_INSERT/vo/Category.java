package vo;

import java.util.ArrayList;

public class Category {
	private String code;
	private String name;
	private ArrayList<Comics> comics;
	
	public Category() {
		this.comics= new ArrayList<>(); 
	}
	
	public Category(String code,String name) {
		this();
		this.code = code;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public void setComics(ArrayList<Comics> comics) {
		this.comics = comics;
	}
	public ArrayList<Comics> getComics(){
		return comics;
	}
	public void addComic(Comics comics) {
		this.comics.add(comics);
	}
}
