import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		int alicesWallet = 0;
		int bobsWallet = 0;
		int data;
		int[] dataArray = new int[2];
		String dataString = "";
		int lastData = 0;
		
		FileInputStream input = new FileInputStream(new File("bank.txt"));
		while(input.available() > 0)
		{
		    data = input.read();
		    switch(data)
		    {
		        case (int)'Y':
		            int toWho = input.read();
		            dataArray[0] = input.read();
		            dataArray[1] = input.read();
		            lastData = input.read();
		            if((char)toWho == 'A')
	                {
		                alicesWallet = alicesWallet + (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
        		    }
        		    else
        		    {
        		        bobsWallet = bobsWallet + (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
        		    }
        		    dataString = "" + toWho + (char)dataArray[0] + (char)dataArray[1] + (char)lastData;
        		    explanation(dataString);
		            break;
		            
	            case (int)'H':
	                toWho = input.read();
		            dataArray[0] = input.read();
		            dataArray[1] = input.read();
		            lastData = input.read();
		            if((char)toWho == 'A')
	                {
		                alicesWallet = alicesWallet - (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
        		    }
        		    else
        		    {
        		        bobsWallet = bobsWallet - (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
        		    }
        		    dataString = "" + toWho + (char)dataArray[0] + (char)dataArray[1] + (char)lastData;
        		    explanation(dataString);
	                break;
                
                case (int)'T':
                    toWho = input.read();
                    int firstData = input.read();
		            dataArray[0] = input.read();
		            dataArray[1] = input.read();
		            lastData = input.read();
		            if((char)toWho == 'A')
	                {
		                alicesWallet = alicesWallet - (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
		                bobsWallet = bobsWallet + (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
        		    }
        		    else
        		    {
        		        bobsWallet = bobsWallet - (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
        		        alicesWallet = alicesWallet + (hexToDec(""+(char)dataArray[0]+(char)dataArray[1]));
        		    }
        		    dataString = "" + toWho + (char)firstData + (char)dataArray[0] + (char)dataArray[1] + (char)lastData;
        		    explanation(dataString);
                    break;
		    }
		}
	}
	
	public static int hexToDec(String hexToDecString)
	{
	    int value = 0;
	    if ( hexToDecString.charAt(0) >= '0' && hexToDecString.charAt(0) <= '9')
	    {
	        if ( hexToDecString.charAt(1) >= '0' && hexToDecString.charAt(1) <= '9')
	        {
	            value = ((int)(hexToDecString.charAt(0) - '0') * 16 + (int)(hexToDecString.charAt(1) - '0'));
	        }
	        else
	        {
	            value = ((int)(hexToDecString.charAt(0) - '0') * 16 + (int)((hexToDecString.charAt(1) - 'A') + 10));
	        }
	    }
	    else if (hexToDecString.charAt(0) >= 'A' && hexToDecString.charAt(0) <= 'F')
	    {
	        if ( hexToDecString.charAt(1) >= 'A' && hexToDecString.charAt(1) <= 'F')
	        {
	            value = ((int)(((hexToDecString.charAt(0) - 'A') + 10) * 16) + (int)((hexToDecString.charAt(1) - 'A') + 10));
	        }
	        else
	        {
	            value = ((int)(((hexToDecString.charAt(0) - 'A') + 10) * 16) + (int)(hexToDecString.charAt(1) - '0'));
	        }
	    }
	    return value;
	}
	
	public static int hexToDec(char hexToDecString)
	{
	    int value = 0;
	    if ( hexToDecString >= '0' && hexToDecString <= '9')
	    {
	        value = (int)(hexToDecString - '0') ;
	    }
	    else if (hexToDecString >= 'A' && hexToDecString <= 'F') 
	    {
	        value = (int)((hexToDecString - 'A') + 10);
	    }
	    return value;
	}
	
	public static void explanation(String dataString)
	{
	    char process = dataString.charAt(0);
	    switch(process)
	    {
	        case 'Y':
	            if (dataString.charAt(1) == 'A')
	            {
	                
	            }
	            else
	            {
	                
	            }
	            break;
	            
            case 'H':
                break;
                
            case 'T':
                break;
	    }
	}
}
