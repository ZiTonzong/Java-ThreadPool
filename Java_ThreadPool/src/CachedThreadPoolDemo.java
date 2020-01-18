import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
	public static void main(String args[]){
		//����һ�������õĹ̶��߳������̳߳�
		ExecutorService pool = Executors.newCachedThreadPool();
		Thread t1 = new MyThread2();
		Thread t2 = new MyThread2();
		Thread t3 = new MyThread2();
		Thread t4 = new MyThread2();
		Thread t5 = new MyThread2();
		//���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		//�ر��̳߳�
		pool.shutdown();
	}
}


class MyThread2 extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ�С���");
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"ִ����ϡ�");
	}
	
}
