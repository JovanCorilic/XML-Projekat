package com.xml.zig.zigbackapp.dto.request.trademark_save_dto;

public class Fee {

	private Long basic;
	
	private Long nice_class;
	
	private Long graphical_solution;


	public Long getBasic() {
		return basic;
	}

	public void setBasic(Long basic) {
		this.basic = basic;
	}

	public Long getNice_class() {
		return nice_class;
	}

	public void setNice_class(Long nice_class) {
		this.nice_class = nice_class;
	}

	public Long getGraphical_solution() {
		return graphical_solution;
	}

	public void setGraphical_solution(Long graphical_solution) {
		this.graphical_solution = graphical_solution;
	}

	@Override
	public String toString() {
		return "Fee [basic=" + basic + ", nice_class=" + nice_class + ", graphical_solution=" + graphical_solution
				+ "]";
	}
	
	
	
}
