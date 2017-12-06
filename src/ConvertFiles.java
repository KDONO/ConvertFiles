import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConvertFiles 
{

public static void main(String args[]) throws IOException
{
	
FileReader data = new FileReader("input.txt");
BufferedReader reader = new BufferedReader(data);

ConvertFiles cf = new ConvertFiles();

ArrayList<Character> output = new ArrayList<Character>();

String read;

while ((read = reader.readLine()) != null) 
{	
	char[] temp = read.toCharArray();
	
	for(int i = 0; i<temp.length;i++)
    	{
    		if(Character.isLetter(temp[i]))
    			output.add(temp[i]);
    	}
}

cf.printJSONFormat(output);

data.close();
}

//properly formats for JSON, with the quotes and commas, and escapes every 5 items
public void printJSONFormat(ArrayList<Character> charArray)
{
	ArrayList<Character> output = new ArrayList<Character>();
	int spaceCount = 0;

	for(int i = 0; i<=charArray.size();i++)
	{
		if(i == 0 || i == (charArray.size()))
		{
			output.add('\"');
		}
		else if( charArray.get(i) == 'â')
		{
			output.add('\"');
			output.add(',');
			output.add('\"');
		}
		else	
			output.add(charArray.get(i));
	}
// Need to find out why I need to skip the first 3 characters :[	
	System.out.print("[");
	for(int i = 3; i<output.size(); i++)
		{
			if(output.get(i) == '\"' || output.get(i) == ',')
			{
				spaceCount++;
				if(spaceCount >= 16)
				{
					System.out.println("");
					spaceCount = 1;
				}
			}
			System.out.print(output.get(i));
		}
	System.out.println("]");
	}
}


