package executor.base;

/**
 * @author zhou
 * @param <T>
 */
public interface Producer<T> {
	/**
	 * 返回一个任务数据单元
	 * @param t
	 * @return
	 */
	public T product(T t);
}
