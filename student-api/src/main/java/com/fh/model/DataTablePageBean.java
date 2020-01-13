package com.fh.model;

public class DataTablePageBean {
	private Integer draw;
	private Integer start;
	private Integer length;
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public DataTablePageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataTablePageBean(Integer draw, Integer start, Integer length) {
		super();
		this.draw = draw;
		this.start = start;
		this.length = length;
	}
	
	
}
