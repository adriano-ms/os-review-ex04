package view;

public class Main {

	public static void main(String[] args) {
		
		int n = 12;
		
		Thread simple = new Thread() {
			@Override
			public void run() {
				long startTime = System.nanoTime();
				long result = 1;
				for(int i = 1; i <= n; i++) {
					result *= i;
				}
				long elapsedTime = System.nanoTime() - startTime;
				System.out.println("Simple: Result = " + result + " Elapsed Time = " + elapsedTime);
			}
		};
		
		Thread recursive = new Thread() {
			@Override
			public void run() {
				long startTime = System.nanoTime();
				long result = fact(n);
				long elapsedTime = System.nanoTime() - startTime;
				System.out.println("Recursive: Result = " + result + " Elapsed Time = " + elapsedTime);
			}
			
			private long fact(int n) {
				if(n == 1) {
					return n;
				}
				return n * fact(n - 1);
			}
		};
		
		simple.start();
		recursive.start();

	}

}
