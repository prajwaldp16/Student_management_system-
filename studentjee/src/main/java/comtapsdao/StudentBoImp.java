package comtapsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comtapsmodules.Student;

public class StudentBoImp implements StudentBo {

	private Connection connection = null;
	private PreparedStatement statement = null ;
	private static final String url = "jdbc:mysql://localhost:3306/jdbcjava";
	private static final String username = "root";
	private static final String password = "root";
	static final String INSERT_QUERY = "INSERT INTO student "
			+ "(id, name, age, address, dept) VALUES (?, ?, ?, ?, ?)";
	
//	constructor
	public StudentBoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username  ,password );
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public int save(Student s) {
		try {
			statement = connection.prepareStatement(INSERT_QUERY);
			
			statement.setInt(1, s.getId());
			statement.setString(2,s.getName());
			statement.setInt(3, s.getAge());
			statement.setString(4,s.getAddress());
			statement.setString(5,s.getDept());
			int i = statement.executeUpdate();
			return i ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	@Override
	public int update(Student s) {
		String UPDATE_QUERY = "UPDATE `student` SET `name` = ?, `age` = ?,"
				+ " `address` = ?, `dept` = ? WHERE `id` = ?";
		 try {
			 statement = connection.prepareStatement(UPDATE_QUERY);
			
			 statement.setString(1,s.getName());
			 statement.setInt(2, s.getAge());
			 statement.setString(3,s.getAddress());
			 statement.setString(4,s.getDept());
			 statement.setInt(5, s.getId());
			
			int i = statement.executeUpdate();
			return i;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int id) {
		
		String DELETE_QUERY ="DELETE FROM student WHERE id = ?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1, id);
			
			int i = statement.executeUpdate();
			
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	

	@Override
	public int delete(Student s) {

		return delete(s);
	}

	 @Override
	    public Student get(int id) {
	        String SELECT_QUERY = "SELECT * FROM student WHERE id = ?";
	        try {
	            statement = connection.prepareStatement(SELECT_QUERY);
	            statement.setInt(1, id);

	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                int studentId = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                int age = resultSet.getInt("age");
	                String address = resultSet.getString("address");
	                String dept = resultSet.getString("dept");

	                return new Student(studentId, name, age, address, dept);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null; // Return null if no student with the specified ID is found
	    }

	 
	 
	    // Implement the getAll() method
	    @Override
	    public List<Student> getAll() {
	        String SELECT_ALL_QUERY = "SELECT * FROM student";
	        List<Student> students = new ArrayList<>();

	        try {
	            statement = connection.prepareStatement(SELECT_ALL_QUERY);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                int studentId = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                int age = resultSet.getInt("age");
	                String address = resultSet.getString("address");
	                String dept = resultSet.getString("dept");

	                students.add(new Student(studentId, name, age, address, dept));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return students;
	    }



}
