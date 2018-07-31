package ThreadExample.base;

public interface JobQueue<T> {
	public T get();
	public void put(T t);
}
