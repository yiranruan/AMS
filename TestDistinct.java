// TestDistinct.java
// A ***SAMPLE*** Testing function for distinct elements counter
// awirth for COMP90056 2018 Assignment A
// Aug 2018


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestDistinct{
	private static ArrayList<String> lines= new ArrayList<String>();
	static int realNum;
	static int times;
	
	public static void main(String args[]){
		TestDistinct tD = new TestDistinct();
		
		if (args.length != 1){
		    System.err.println("Should be only one argument, the filename.\n");
		    System.exit(1);
		}
		tD.readFile(args);
		try {
			
			for(int time : times) {
				for (int r = 1; r <= 200; r++) {
					FileWriter writer = new FileWriter(new File(dataFile),true);
					writer.write("times = "+ time+"\n");
					writer.close();
					tD.AMSTest(time);
				}
				FileWriter writer = new FileWriter(new File(dataFile),true);
				writer.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile(String args[]) {
		if (args.length != 1){
		    System.exit(1);
		}
		String filename = args[0]; // argument is filename.
	    try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine())!=null) {
				lines.add(line);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AMSTest() {
		try {
			FileWriter writer = new FileWriter(new File(dataFile),true);
			//Distinct d = new AMS(0x0fffffff,10,18);
			float avg = 0;
			int i;
			Distinct d = null;
			double[] median = new double[times];
			for (i = 0; i < times; i++) {
				try {
					startMem = run.totalMemory()-run.freeMemory();
					d = new AMS(0x0fffffff,10,18);
					for(int j = 0;  j < lines.size(); j++) {
						d.add(lines.get(j));
					}
				    median[i]=d.distinct();
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				    System.exit(1);
				}
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static double getMedian(double[] data) {
	    double[] copy = Arrays.copyOf(data, data.length);
	    Arrays.sort(copy);
	    // if the length is odd, return the middle item, else return the average of the two middle items
	    return (copy.length % 2 != 0) ? copy[copy.length / 2] : (copy[copy.length / 2] + copy[(copy.length / 2) - 1]) / 2;
	} 
	
}