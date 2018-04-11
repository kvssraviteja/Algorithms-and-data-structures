import java.util.Random;

public class CompareHash
{
	// performs linear probing when collision occurs 
	public static int  hashing_LinearProbing(UserHashTable hashTable, int[] keys)//h(k,i) = (h0(k) + i)%m
	{
		int probes = 0;// everytime a postion in the hash table is probed, it's count is increased
		int pos, m= hashTable.length;
		for(int i =0; i < 1100; i++)
		{
			pos = keys[i]%m;
			if(hashTable.isExists(keys[i]))//if key exists, count will be incremented
			{
				hashTable.increment_count(keys[i]);
			}
			else
			{
					int count = 0;
					int newpos= pos;
					int t= 1;
					while(count < m)
					{
						if(hashTable.isFree(newpos)) 
						{
							probes++;
							hashTable.insert(keys[i], newpos);
							break;
						}
						newpos = (pos + t)%m;
						t++;
						probes++;// increments probe count whenever an empty place is not found 
						count++;
					}
			}
		}
		return probes;
	}
	
	// performs quadratic probing when collision occurs
	public static int hashing_QuadraticProbing(UserHashTable hashTable, int[] keys)//h(k,i) = (h0(k) + i^2)%m
	{
		int probes = 0,pos, m= hashTable.length;
		for(int i =0; i < 1100; i++)
		{
			pos = keys[i]%m;
			if(hashTable.isExists(keys[i]))//if key exists, count will be incremented
			{
				hashTable.increment_count(keys[i]);
			}
			else
			{
					int count = 0;
					int t =1;
					int newpos = pos;
					while(count < m)
					{
						if(hashTable.isFree(newpos)) 
						{
							probes++;
							hashTable.insert(keys[i], newpos);
							break;
						}
						newpos = (pos + (t*t))%m;
						probes++;
						t++;
						count++;
					}
			}
		}
		return probes;
	}
	
	//performs double hashing when collision occurs
	public static int hashing_DoubleHashing(UserHashTable hashTable, int[] keys)//h(k,i) = (h0(k) + i*h1(k))%m
	{
		int probes = 0,pos, m= hashTable.length;
		for(int i =0; i < 1100; i++)
		{
			pos = keys[i]%m;
			if(hashTable.isExists(keys[i]))//if key exists, count will be incremented
			{
				hashTable.increment_count(keys[i]);
			}
			else
			{
					int count = 0;
					int t =1;
					int pos2 = 1 + (keys[i]%(m-1));//h1(k) = 1 + (keys%(m-1))
					int newpos= pos;
					while(count < m)
					{
						if(hashTable.isFree(newpos))
						{
							probes++;
							hashTable.insert(keys[i], newpos);
							break;
						}
						newpos = (pos + (t*pos2))%m;
						probes++;
						t++;
						count++;
					}
			}
		}
		return probes;
	}
	
	public static void main(String[] args)
	{
		int m = 2447;//declaring size of the hash table
		Random rand = new Random();
		int[] rand_int = new int[1100];//array to store the generated random numbers
		for(int i =0; i < 1100; i++)
		{
			rand_int[i] = rand.nextInt(10001);
		}
		
		//creating 3 UserHashtable objects for each probing techniques
		UserHashTable hashTable1 = new UserHashTable(m);
		UserHashTable hashTable2 = new UserHashTable(m);
		UserHashTable hashTable3 = new UserHashTable(m);
		
		//calling each probing technique with HashTable object and array of random integers
		int probes1 = hashing_LinearProbing(hashTable1, rand_int);
		int probes2 = hashing_QuadraticProbing(hashTable2, rand_int);
		int probes3 = hashing_DoubleHashing(hashTable3, rand_int);
		
		//printing the output
		System.out.println("Number of probes for m = "+m);
		System.out.println("\nLinear probing : "+ probes1);
		System.out.println("Quadratic probing : "+ probes2);
		System.out.println("Double hashing : "+ probes3);
		
	}
}