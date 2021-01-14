package com.hcl.domain;

/*@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Getter*/
public class Student {

	private String studentName;
	private String studentClass;

	public Student(String studentName, String studentClass) {
		super();
		this.studentName = studentName;
		this.studentClass = studentClass;
	}

	public Student() {
		super();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentClass=" + studentClass + "]";
	}

}
