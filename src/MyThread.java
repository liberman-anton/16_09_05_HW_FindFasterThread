import java.util.Random;

public class MyThread extends Thread {
	private int nIterations;
	private int maxTimeOfWaiting;
	
	public MyThread(int nIterations, int maxTimeOfWaiting) {
		super();
		this.nIterations = nIterations;
		this.maxTimeOfWaiting = maxTimeOfWaiting;
	}

	@Override
	public void run(){
		Random gen = new Random();
		String name = currentThread().getName();
		for(int i = 0; i < nIterations; i++){
			try {
				sleep(gen.nextInt(maxTimeOfWaiting));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);			
		}
		//FindFasterThreadAppl.resalts.add(name);
		if(FindFasterThreadAppl.winner.equals(""))FindFasterThreadAppl.winner = name;
		System.out.println(name + " is competed");
	}
}
