package GuavaExample;

import com.google.common.primitives.Bytes;

import java.util.List;

public class BytesExample {
	public static void main(String[] args) {
		byte[] byteArray = {1,2,3,4,5,6,7,9,9};

		// Array 转换 List
		List<Byte> byteList = Bytes.asList(byteArray);
		System.out.println(byteList.toString());

		// List 转换为 Array
		byteArray = Bytes.toArray(byteList);
		System.out.print("[");
		for (int i = 0; i < byteArray.length; i++) {
			System.out.print(byteArray[i] + " ");
		}
		System.out.println("]");

		Byte data = 5;
		// 判断是否包含
		System.out.println("Is data array contains 5 ? " + Bytes.contains(byteArray, data));

		// 这里特意查询9的index， 返回的是第一个匹配项
		data = 9;
		System.out.println("Index of 5: " + Bytes.indexOf(byteArray, data));

		// 这里返回最后一个匹配项
		System.out.println("Index of 5: " + Bytes.lastIndexOf(byteArray, data));

	}
}
