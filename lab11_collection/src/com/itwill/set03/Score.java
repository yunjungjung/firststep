package com.itwill.set03;

import java.util.Objects;

public class Score {
	// 필드
	private int java;
	private int sql;
	private int html;

	
	// 기본 생성자
	public Score() {}

	// 아규먼트를 가진 생성자
	public Score (int java, int sql, int html) {
		this.java = java;
		this.sql = sql;
		this.java = html;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getSql() {
		return sql;
	}

	public void setSql(int sql) {
		this.sql = sql;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}
	
	@Override
	public String toString() {
		return "Score(java=" + java 
				+ ", sql=" + sql 
				+ ", html=" + html 
				+ ")";
				
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return html == other.html && java == other.java && sql == other.sql;
	}
	@Override
	public int hashCode() {
		return Objects.hash(html, java, sql);
	}
}
	

