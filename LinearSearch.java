package programming.com;

public class LinearSearch {

	public static void main(String[] args) {
		int arr2[]= {12,54,32,43,-434,2,43,};
		
		int key2=-434;
		System.out.println("Seaching for an element in array:");
		System.out.println(key2+" at "+Search(arr2, key2));

	}
	
	public static int Search(int [] arr , int key)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==key)
			{
				
				return i;
			}
		}
		
		return -1;
	}

}
