import java.util.Arrays;

// AMS.java
// AMS distinct elements counter
// awirth for COMP90056
// Aug 2017,8

public class AMS implements Distinct{
	private int zs[];
	private int n;	//domain and range
	private Hash hs[];
	private int range = 536870912-3;//2^29-3
	private double max;
	//private int c=1835; //from the formula!
	private int c=18; //NOT from the formula!
	private int k;
		
	public AMS(int n,int del1,int c){
		k = (int) Math.ceil(c*Math.log(del1));
		this.n = n;
		
		zs = new int[k];
		hs = new Hash[k];
		for(int i=0;i<k;i++){
			// create k new hash functions
			hs[i] = new Hash();
		}
		
	}
	
	public void add(String o){
		if (max < Integer.parseInt(o)) {
			max = Integer.parseInt(o);
		}
		for(int i=0;i<k;i++){
			int val = Hash.h_basic(o,n);
			val = hs[i].h2u(val, range);
			int nz = Distinct.zeros(val);
			// for each hash function, store the maximum number of
			// zeros seen
			if(nz > zs[i]){
				zs[i] = nz;
			}
		}
	}
	
	public static double getMedian(int[] data) {
	    int[] copy = Arrays.copyOf(data, data.length);
	    Arrays.sort(copy);
	    // if the length is odd, return the middle item, else return the average of the two middle items
	    return (copy.length % 2 != 0) ? copy[copy.length / 2] : (copy[copy.length / 2] + copy[(copy.length / 2) - 1]) / 2;
	} 
	
	public static double getAvg(int[] data) {
		double avg = 0;
		for (int i : data) {
			avg += i;
		}
		avg = avg/data.length;
		
		return avg;
	}
	
	public double distinct(){
		double z = getAvg(zs);
		if ((max/Math.pow(2,z))<2) {
			max = (max+Math.pow(2,z))/2;
		}else {
			max = Math.pow(2, z);
		}
		return Math.pow(2, z+Math.log(max/Math.pow(2, z)) / Math.log(2));
	}
	
}

