package java_professional.lesson_4;

public class TestMain {
    private final Object guardA = new Object();
    private final Object guardB = new Object();
    private final Object guardC = new Object();
    private int threadId = 1;

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
            for (int i = 0; i < 5; ++i) {
                while (threadId != 1) {
                    try {
                        synchronized (guardA) {
                            guardA.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println('A');
                threadId = 2;
                synchronized (guardB) {
                    guardB.notify();
                }
            }

    }

    private void printB() {
            for (int i = 0; i < 5; ++i) {
                while (threadId != 2) {
                    try {
                        synchronized (guardB) {
                            guardB.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println('B');
                threadId = 3;
                synchronized (guardC) {
                    guardC.notify();
                }
            }

    }

    private void printC() {
            for (int i = 0; i < 5; ++i) {
                while (threadId != 3) {
                    try {
                        synchronized (guardC) {
                            guardC.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println('C');
                threadId = 1;
                synchronized (guardA) {
                    guardA.notify();
                }
            }

    }
}
