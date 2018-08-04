package main.com.neptune8.juc;

public class TestHappenBefore {
	private static volatile Integer something = 1;

	private static void setSomething(Integer j) {
		something = j;
	}

	private static Integer getSomething() {
		return something;
	}

	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				TestHappenBefore.setSomething(10);
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(TestHappenBefore.getSomething());
			}
		}).start();

	}
}
