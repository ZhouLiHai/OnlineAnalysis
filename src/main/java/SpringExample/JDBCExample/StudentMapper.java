package SpringExample.JDBCExample;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// 辅助函数，在查询单个或者列表对象的时候需要用到
public class StudentMapper implements RowMapper<Student> {
	@Override
	public Student mapRow(ResultSet resultSet, int i) throws SQLException {
		Student student= new Student();
		student.setId(resultSet.getInt("id"));
		student.setAge(resultSet.getInt("age"));
		student.setName(resultSet.getString("name"));
		return student;
	}
}
