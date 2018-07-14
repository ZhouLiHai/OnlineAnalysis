package SpringExample.JDBCExample;

import SpringExample.Beans.InnerBean;

import javax.sql.DataSource;
import java.util.List;

// 数据访问接口，可以被不同类型的数据源多次实现
public interface StudentDao {
	public void setDataSource(DataSource dataSource);
	public void create(String name, Integer age);
	public Student getStudent(Integer id);
	public List<Student> listStudents();
	public void delete(Integer id);
	public void update(Integer id, Integer age);
}
