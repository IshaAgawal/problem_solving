import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	Queue<Integer> q = new LinkedList<Integer>();
	int capacity = 4;

	void produce() throws InterruptedException {

		int value = 0;

		while (true) {

			synchronized (this) {

				while (q.size() == capacity)
					wait();

				System.out.println("Producer produced " + value);

				q.add(value++);

				notify(); // notify the customer thread that it can consume

				Thread.sleep(1000);
			}

		}

	}

	void consume() throws InterruptedException {

		while (true) {

			synchronized (this) {

				while (q.size() == 0)
					wait();
				System.out.println("Cosumed " + q.poll());

				notify(); // notify the producer thread

				Thread.sleep(1000);

			}
		}
	}
}