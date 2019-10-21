package activities.exercise2;

/**
 * Crie uma classe SharedFifoQueue e use Conditions para controlar se a fila
 * está vazia ou cheia. Teste usando threads produtoras e consumidoras.
 * 
 * @author daniel
 */
public class Exercise2 {
	public static void main(String[] args) {
		QueueLock queue = new QueueLock(3);
		new Thread(new Producer(queue, 1000)).start();
		new Thread(new Producer(queue, 1000)).start();
		new Thread(new Producer(queue, 1000)).start();
		new Thread(new Consumer(queue)).start();
	}
}
