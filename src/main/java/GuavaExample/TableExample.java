package GuavaExample;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import java.util.Map;
import java.util.Set;

public class TableExample {
	public static void main(String[] args) {
		/**
		 * table 就是一个二维的map，拥有两个键，一个值
		 * 两个键同时在一个二维表上定位一个值
		 */
		Table<String , Integer, String > table = HashBasedTable.create();

		table.put("IBM", 101, "a");
		table.put("IBM", 102, "b");
		table.put("IBM", 103, "c");
		table.put("MSS", 111, "d");
		table.put("MSS", 112, "e");
		table.put("MSS", 113, "f");
		table.put("ORO", 121, "j");
		table.put("ORO", 122, "k");
		table.put("ORO", 123, "l");

		//寻找所有row是IBM的单元
		Map<Integer ,String> ibmEmployees = table.row("IBM");

		for (Map.Entry<Integer, String> entry : ibmEmployees.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// 获取所有row key
		Set<String> employees = table.rowKeySet();

		for (String employee : employees) {
			System.out.println(employee);
		}

		// 转换 row key 和 column key
		Table<Integer,String,String> table1 = Tables.transpose(table);

		// 转换之后和上次结果一样
		Set<String> ids = table1.columnKeySet();

		for (String id: ids) {
			System.out.println(id);
		}

		// 根据一个数据寻找另外两个数据
		// 如果有两个102，则后面一个会覆盖前面一个
		Map<String, String> employeeMap = table.column(102);

		for (Map.Entry<String, String> entry: employeeMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}
