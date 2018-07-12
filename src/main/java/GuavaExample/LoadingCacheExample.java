package GuavaExample;

import afu.org.checkerframework.checker.igj.qual.I;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LoadingCacheExample {
	public static void main(String[] args) {
		/**
		 * expireAfterAccess: 当缓存项在指定的时间段内没有被读或写就会被回收。
		 * expireAfterWrite： 当缓存项在指定的时间段内没有更新就会被回收。
		 * refreshAfterWrite：当缓存项上一次更新操作之后的多久会被刷新。
		 */
		LoadingCache studentCache = CacheBuilder.newBuilder()
				.maximumSize(20)
				.expireAfterAccess(3, TimeUnit.SECONDS)
				.build(new CacheLoader() {
					@Override
					public Object load(Object Id) throws Exception {
						return getFromDatabase((String) Id);
					}
				});

		try {

			// 第一次从load函数中获取数据，这里可以是数据库
			System.out.println("data load form database.");
			System.out.println(studentCache.get("100"));
			System.out.println(studentCache.get("103"));
			System.out.println(studentCache.get("110"));

			// 第二次从cache中获取数据
			System.out.println("data load from cache.");
			System.out.println(studentCache.get("100"));
			System.out.println(studentCache.get("103"));
			System.out.println(studentCache.get("110"));

			Thread.sleep(5000);

			// 想模拟3秒超时，但不起作用
			System.out.println("3");
			System.out.println(studentCache.get("100"));
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static Student getFromDatabase(String Id) {
		Map<String, Student> database = new HashMap();
		database.put("100", new Student("a", "b", 100, "1"));
		database.put("103", new Student("c", "d", 103, "1"));
		database.put("110", new Student("e", "f", 110, "1"));

		System.out.println("load data by id: " + Id);
		return database.get(Id);
	}
}

