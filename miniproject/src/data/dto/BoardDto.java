package data.dto;

import java.sql.Timestamp;

// 넘, 아이디, 제목, 내용, reg, restep, relevel, readcount, writeday 를 담을 프로퍼티(멤버변수)
// 프로퍼티에 직접 접근할 수 없게 private를 사용한다.
public class BoardDto {
	private int num;
	private String myid;
	private String subject;
	private String content;
	private int reg;
	private int restep;
	private int relevel;
	private int readcount;
	private Timestamp writeday;
	private int acount;
	 
    /* 데이터를 가져오거나(get), 세팅하는(set)
    *  기능을 하는 메서드를 만든다.
    *  - 데이터를 가져오는 경우 - get메서드
    *  - 데이터를 세팅하는 경우 - set메서드
    */
	
	
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
	}
	public int getNum() { //게터의 리턴타입 int로
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMyid() {
		return myid;
	}
	public void setMyid(String myid) {
		this.myid = myid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReg() {
		return reg;
	}
	public void setReg(int reg) {
		this.reg = reg;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
		
}
