import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolDemo {
	public static void main(String args[]){
		//����һ��ʹ�õ���worker�̵߳�Executor�����޽���з�ʽ�����и��߳�
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		Runnable task1 = new SingleTask();
		Runnable task2 = new SingleTask();
		Runnable task3 = new SingleTask();
		
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		
		/**
		 * ����shutdown()������shutdownNow()�����������ӳ�5���ִ�йر��̳߳ط���������
		 * showdownNow���������ִ�еڶ����߳�����ʱ���ϴ����ִ������׳�sleep interrupted�쳣��
		 * �������showdown������������еȴ�ִ�е��߳�ȫ��ִ�����Źر��̳߳ء�
		 */
		try {
	        Thread.sleep(5000);//���������5000����5000���룬Ҳ����5�룬���Ըó�����Ҫ��ʱ��
	} catch (InterruptedException e) {
	        e.printStackTrace();
	}
		//pool.shutdownNow();
		//�ر��̳߳أ��ȴ��Ѿ��ύ������ȫ�����������ٽ����µ�����
				pool.shutdown();
	}
	
}

class SingleTask implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ�С���");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"ִ�����");
	}
	
}
