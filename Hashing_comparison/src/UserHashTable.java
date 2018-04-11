//Class to store keys and the count for the keys
public class UserHashTable {

	int length;
	int[] keys;
	int[] count;
	public UserHashTable(int l)
	{
		length = l;
		keys = new int[l];
		count = new int[l];
	}
	
	public boolean isExists(int key)//checks the key exists already in the table or not, if exists returns true
	{
		int i;
		for(i = 0; i < length; i++)
		{
			if(keys[i] ==  key)
				break;
		}
		if(i < length)
			return true;
		else 
			return false;
	}
	
	public void insert(int key, int pos)// inserts key into the position denoted by "pos"
	{
		keys[pos]= key;
		count[pos]=1;
	}
	
	public void increment_count(int key)// increments the value of count for a given key
	{
		int i;
		for(i = 0; i < length; i++)
		{
			if(keys[i] ==  key)
				break;
		}
		if(i < length)
			count[i]++;
	}
	public boolean isFree(int pos)// checks whether the position "pos" has any key or not
	{
		if(keys[pos] == 0)
			return true;
		else 
			return false;
	}

}
