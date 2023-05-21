package cpu;

import java.util.LinkedList;

//Any object of MemoryPages represents the memory status at a certain time
// It corresponds to a column of the page replacement table in the lecture note
class MemoryPages{
	int pages[]; //This data member holds the pages at the current time in the memory, at most 4 elements
	int time_stamp[]; //It records the time (moment) the corresponding page was inserted into the RAM
	boolean ref_bit[];
	int time_index; //represents the time point of the current memory
	
	MemoryPages(int size, int idx) {
		pages = new int[size]; //initialize the number of pages for the current memory
		time_index = idx; //This variable is assigned a time stamp for the current memory
		time_stamp = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			pages[i] = -1;
			time_stamp[i] = -1;
		}
	}
	
	MemoryPages(int size, int idx, int pages[], int time_stamp[]) {
		this.pages = new int[size];
		this.time_stamp = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			this.pages[i] = pages[i];
			this.time_stamp[i] = time_stamp[i];
		}
	}
	
}

//Represents the Memory Management component 
public class PageReplacement {

	static int capacity = 4; //The RAM has 4 pages of size
	static int page_fault_count = 0; //Increase 1 everytime if there is a page replacement needed
	
	static LinkedList<MemoryPages> page_list = new LinkedList<>(); //This variable record all the memory status during the whole time
				//It corresponds to the whole page replacement table in the lecture note. 
	
	// i represent a certain moment along the time line 
	//Create a MemoryPages object for each request_page,
	// (1) Assign i to the time_index 
	// (2) insert the current page into MemoryPages object if there is available space
	// (3) Otherwise, find a page for replacement
	
	static void LRUreplacement(int request_pages[]) {

		for(int i = 0; i < request_pages.length; i++)
		{
			MemoryPages mp;
			if(i == 0)
				mp = new MemoryPages(capacity, i); //At the moment 0, create an empty memory
			else
			{
				mp = new MemoryPages(capacity, i, page_list.get(i-1).pages, page_list.get(i-1).time_stamp);
			}
			
			int idx = 0;
			for(idx = 0; idx < capacity; idx++)
			{
				if(mp.pages[idx] == -1)  //The memory has available space
				{
					mp.pages[idx] = request_pages[i]; //use the current unit to assign the requested page
					mp.time_stamp[idx] = i; //i is the time the page is placed into RAM 
					break;
				}
				else if(mp.pages[idx] == request_pages[i]) //The currently requested page is already in the RAM
				{
					mp.time_stamp[idx] = i; //The page has been requested before, so just update the time stamp
					break;
				}
			}
			
			//Check if there is a need for page replacement
			if(idx >= capacity) //if the RAM has been traversed but did not assign the currently requested page, then perform page replacement
			{
				page_fault_count++;
				
				//Traverse the RAM pages's time stamp and find the minimum one
				int min_timestamp = 1000;
				int min_idx = -1;
				for(idx = 0; idx < capacity; idx++) {
					if(mp.time_stamp[idx] < min_timestamp) {
						min_timestamp = mp.time_stamp[idx];
						min_idx = idx;
					}
				}
				
				//After the loop min_idx stores the location of the oldest page
				mp.pages[min_idx] = request_pages[i]; //use the current unit to assign the requested page
				mp.time_stamp[min_idx] = i; //i is the time the page is placed into RAM 
				
				
			}
			
			// Record how many times of page_fault and increase page_fault_count
			
			page_list.add(mp);
		}
		
		
		//After finishing all the page request, print out the memory status table, with each row representing a time moment of the RAM status
		for(int i = 0; i < page_list.size(); i++)
		{
			for(int idx = 0; idx < page_list.get(i).pages.length; idx++)
			{
				System.out.print(page_list.get(i).pages[idx] + ", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		int pages[] = {7, 2, 1, 0, 5, 4, 7, 3, 0, 2, 4, 5, 7};  //This array represents the sequence of page requesting by CPU along the timeline.
		PageReplacement.LRUreplacement(pages);
	}
	
}