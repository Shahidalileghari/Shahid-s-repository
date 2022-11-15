import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class TryCatchblock {

	public static void main(String[] args) {
		
    int number=Integer.parseInt(args[0]);
    
    Random gen=new Random();
    
    try {
    	FileOutputStream fileOutput=new FileOutputStream("File.txt");
    	
    	DataOutputStream dosDataOutpu=new DataOutputStream(fileOutput);
    	
    	int i;
    	
    	for(i=0;i<number;i++)
    	
    		dosDataOutpu.writeInt(gen.nextInt(number+1));
    	
    	dosDataOutpu.close();
    		
    	
		
	}
    catch (IOException e) 
    {
		System.out.println("An error occured "+e.toString());
	}
    
   try {
	FileInputStream file=new FileInputStream("File2.txt");
	DataInputStream data=new DataInputStream(file);
	while(true)
	{
		int i=data.readInt();
		
		System.out.println(i);
	}
	
          } catch (EOFException e) {
        	  System.out.println("\nAll is done");
		}
 
   catch (IOException e) {
	System.out.println("An error occured "+e.toString());
	
       }
    

	}

}
