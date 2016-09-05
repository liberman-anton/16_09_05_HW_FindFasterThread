import java.io.*;
import java.util.LinkedList;


public class FindFasterThreadAppl {

	private static final String DELIMETER = "/";
	static volatile LinkedList<String> resalts = new LinkedList<>();

	public static void main(String[] args) {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Numbers of threads? Numbers of iteration? Time of waiting? Delimeter = " + DELIMETER);
		String line = new String();
		try {
			line = console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] parameters = line.split(DELIMETER);
		int nThreads = Integer.parseInt(parameters[0]);
		int nIterations = Integer.parseInt(parameters[1]);
		int maxTimeOfWaiting = Integer.parseInt(parameters[2]);
		Thread[] threads = start(nThreads,nIterations,maxTimeOfWaiting);
		joinThreads(threads);
		System.out.println("Resalts: " + resalts);
		
	}

	private static void joinThreads(Thread[] threads) {
		for(int i = 0; i < threads.length; i++)
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static Thread[] start(int nThreads, int nIterations, int maxTimeOfWaiting) {
		Thread[] threads = new Thread[nThreads];
		for(int i = 0; i < nThreads; i++){
			threads[i] = new MyThread(nIterations, maxTimeOfWaiting);
			threads[i].start();
		}
		return threads;
	}

}
