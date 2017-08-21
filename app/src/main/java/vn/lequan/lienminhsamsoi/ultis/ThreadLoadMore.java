package vn.lequan.lienminhsamsoi.ultis;

public class ThreadLoadMore extends Thread {
    private Runnable runnable;

    public ThreadLoadMore(Runnable runnable) {
        super(runnable);
        this.runnable = runnable;
    }

    public void run() {
        this.runnable.run();
    }
}
