package com.ducat;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student implements Serializable{
	private String name;
	private String course;
	private Float fee;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Float getFee() {
		return fee;
	}
	public void setFee(Float fee) {
		this.fee = fee;
	}
	public boolean save()
	{
		// save data into database.
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
					PreparedStatement ps = con.prepareStatement("insert into students(name,course,fee) values(?,?,?)");
					ps.setString(1,name);
					ps.setString(2,course);
					ps.setFloat(3, fee);
					ps.executeUpdate();
					return true;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
	}
	

}
