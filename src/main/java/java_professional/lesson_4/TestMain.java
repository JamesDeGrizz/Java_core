package java_professional.lesson_4;

public class TestMain {
	private Object guard = new Object();
	private volatile int threadId = 1;

	public static void main(String[] args) {
		TestMain tm = new TestMain();
		Thread a = new Thread(() -> {
			tm.printA();
		});

		Thread b = new Thread(() -> {
			tm.printB();
		});

		Thread c = new Thread(() -> {
			tm.printC();
		});

		a.start();
		b.start();
		c.start();
	}

	private void printA() {
		try {
			for (int i = 0; i < 5; ++i) {
				synchronized (guard) {
					while (threadId != 1) {
						guard.wait();
					}
					System.out.println('A');
					threadId = 2;
					guard.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void printB() {
		try {
			for (int i = 0; i < 5; ++i) {
				synchronized (guard) {
					while (threadId != 2) {
						guard.wait();
					}
					System.out.println('B');
					threadId = 3;
					guard.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void printC() {
		try {
			for (int i = 0; i < 5; ++i) {
				synchronized (guard) {
					while (threadId != 3) {
						guard.wait();
					}
					System.out.println('C');
					threadId = 1;
					guard.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
