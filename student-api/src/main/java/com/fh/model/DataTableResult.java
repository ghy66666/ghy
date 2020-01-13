package com.fh.model;

import java.util.List;

public class DataTableResult {
	private int draw;
	private long recordsFiltered;
	private long recordsTotal;
	private List data;
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public DataTableResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataTableResult(int draw, long recordsFiltered, long recordsTotal, List data) {
		super();
		this.draw = draw;
		this.recordsFiltered = recordsFiltered;
		this.recordsTotal = recordsTotal;
		this.data = data;
	}
	
	
	
}
