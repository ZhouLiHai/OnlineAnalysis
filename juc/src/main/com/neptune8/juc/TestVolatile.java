package main.com.neptune8.juc;

/**
 * @author
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class TestVolatile {
	public static void main(String[] args) {
		Worker worker = new Worker();
		//noinspection AlibabaAvoidManuallyCreateThread
		new Thread(worker).start();

		while (true) {
			if (worker.isFlag()) {
				System.out.println("######");
				break;
			}
		}

	}
}


class Worker implements Runnable {
	private volatile boolean flag = false;

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		flag = true;

		System.out.println("flag " + flag);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
