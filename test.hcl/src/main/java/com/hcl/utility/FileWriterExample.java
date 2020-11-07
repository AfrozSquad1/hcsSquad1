package com.hcl.utility;

import java.io.FileWriter;  
public class FileWriterExample { 
	
	public static void writeOnTextFile(String Content) {
		
		   try{    
	           FileWriter fw=new FileWriter("C:\\Users\\afroz_a\\git\\hcsSquad1\\test.hcl\\exportedData\\ClientText.txt");    
	           fw.write(Content);    
	           fw.close();   
	           System.out.println("Write Done !!!.");    
	          }catch(Exception e){System.out.println(e);}   
		
	}
   
}  