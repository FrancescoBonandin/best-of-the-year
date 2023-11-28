package org.java.spring.pojo;

public class Song {
	
	
	private int id;
	private String title;
	
	public Song( int id, String title) {
		
		setId(id);
		setTitle(title);
	}
	

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}
	
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
//	Feature non funzionante	

//	public Song(String title) {
//		
//		autoIncrementId();
//		setTitle(title);
//		
//	}
//	private static int nextId=1;
//
//	public static int getNextId() {
//		return nextId;
//	}
//
//	private static void setNextId() {
//		Song.nextId++;
//	}
//
//	private void autoIncrementId() {
//		setId(getNextId());
//		setNextId();
//	}
	
	@Override
	public String toString() {
		
		return "id=" + getId() + ", title=" + getTitle();
		
	}
}
