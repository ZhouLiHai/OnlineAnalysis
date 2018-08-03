package executor.base;

/**
 * @author zhou
 * @param <T>
 */
public interface Customer<T> {
	/**
	 * 消费一个任务数据单元
	 * @param t
	 */
	public void consume(T t);
}
