package com.jsp.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jsp.student.dto.Student;
import com.jsp.student.util.HelperClass;

public class StudentCrud {
	HelperClass helperClass = new HelperClass();
	
	public void saveStudent(Student student) {
Connection	connection=	helperClass.getConnection();
	
	String sql ="INSERT INTO student values(?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
		boolean b=	preparedStatement.execute();
			if (b) {
				System.out.println("enter");
			} else {
				System.out.println("not enter");
			}
			if(connection!=null)
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteStudentById(int id ) {
		Connection connection=helperClass.getConnection();
		String sql="DELETE FROM student WHERE ID=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int id2=preparedStatement.executeUpdate();
			if(id2>0) {
				System.out.println("Student Deleted");
			}else {
				System.out.println("Not deleted");
			}
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student) {
		Connection connection=helperClass.getConnection();
		String sql="update student set name=? , email=? WHERE ID=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			int id2=preparedStatement.executeUpdate();
			if (id2>0) {
				System.out.println("succesfullu update");
			} else {
				System.out.println("not update");
			}
			
			if (connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void selectStudent() {
		Connection connection=helperClass.getConnection();
		String sql=" select * from student";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet resultSet;
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + "    ");
				System.out.print(resultSet.getString(2)+ "     ");
				System.out.println(resultSet.getString(3));
				System.out.println("-------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void batchExecution(List<Student> list) {
		Connection connection=helperClass.getConnection();
		String sql="INSERT INTO student values(?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			for (Student student : list) {
				preparedStatement.setInt(1, student.getId());
				preparedStatement.setString(2, student.getName());
				preparedStatement.setString(3, student.getEmail());
				preparedStatement.addBatch();
				System.out.println("student added --> "+ student.getName());
			}
			preparedStatement.executeBatch();
			if (connection!=null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
