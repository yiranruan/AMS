// CreateDistinct.java
// Creates some test data
// COMP90056 2018s2 Assignment A

public class CreateDistinct{ 
	public static void main(String args[]){
		
		for(int i=0;i < 40; i++){
			for(int j = 0; j< 1000; j++){
				System.out.println((int) (Math.random()*10000));
			}
		}
	}
	
}
