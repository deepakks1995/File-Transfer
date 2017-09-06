/*Not Included in the Project */
import java.io.*;
import java.util.*;

class main
{
	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String src="E:\\music\\lat",dest;
		File folder;
		File[] listOfFiles;

		/*for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile())
				System.out.println("File " + listOfFiles[i].getName());
			else if (listOfFiles[i].isDirectory())
				System.out.println("Directory " + listOfFiles[i].getName());
		}*/
		Queue<String> que = new Queue<String>();
		que.insert(src);
		String path = "E:\\music\\lat";
		while(!que.IsEmpty())
		{
			path = que.remove();
			System.out.println(path);
			folder = new File(path);
			listOfFiles = folder.listFiles();
			for(int i=0; i < listOfFiles.length; ++i)
			{
				if (listOfFiles[i].isDirectory())
					que.insert((String)listOfFiles[i].getName());
			}
		}
	}
}
class Queue<T>
{
	protected LinkedList<T> list = new LinkedList<T>();
	boolean IsEmpty()
	{
		return list.size()==0;
	}
	void insert(T e)
	{
		list.add(e);
	}
	T remove()
	{
		T e = list.getFirst();
		list.removeFirst();
		return e;
	}
}
