package org.cap.demo;

public class MyClass {
	
	int[] arr={1,2,3,10};
	
	public void display(){
		int sum=0;
		System.out.println("Arrays");
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		
			System.out.println("Sum:" + sum);
	}

}
