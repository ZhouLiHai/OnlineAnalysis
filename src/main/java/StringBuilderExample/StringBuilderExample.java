package StringBuilderExample;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();

		// 在这里可以随意在字符末尾增加字符
		builder.append(1).append(1.0).append(123456L).append("hello").append('#');

		// 使用toString打印字符串
		System.out.println(builder.toString());

		// 这里代码检查点的意思是为字符串追加一个二进制字符用，应该是unicode
		builder.appendCodePoint(0x37);
		System.out.println(builder.toString());

		// 清空字符串
		builder.setLength(0);
		builder.append("world!");
		builder.insert(0, "hello ");
		System.out.println(builder);

		// delete的end不包含end位置的那个字符
		builder.delete(0, 6);
		System.out.println(builder);

		// 因为不包含end位置的字符，所以这样做是不会删除字符的
		builder.delete(0,0);
		System.out.println(builder);

		// 更改某个位置的字符
		builder.setCharAt(0, 'W');
		System.out.println(builder);

		
	}
}
