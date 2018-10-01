package util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.SearchItem;

public class SortResultsList {
	
	private SortResultsList() {
	}

	public static void byPrice(List<SearchItem> searchItemList, boolean printResult) {
		Collections.sort(searchItemList, new Comparator<SearchItem>() {

		    public int compare(SearchItem p1, SearchItem p2) {
		         return Float.compare(p1.getPrice(),p2.getPrice());
		    }
		});
		if(printResult) {
			printSearchResultList(searchItemList, "Price");
		}
	}
	
	public static void byRating(List<SearchItem> searchItemList, boolean printResult) {
		Collections.sort(searchItemList, new Comparator<SearchItem>() {

		    public int compare(SearchItem p1, SearchItem p2) {
		         return Float.compare(p2.getRating(),p1.getRating());
		    }
		});
		
		if(printResult) {
			printSearchResultList(searchItemList, "Rating");
		}
	}
	
	public static void byGeneralQualification(List<SearchItem> searchItemList) {
		Collections.sort(searchItemList, new Comparator<SearchItem>() {

		    public int compare(SearchItem p1, SearchItem p2) {
		         return p1.getGeneralQualification() -p2.getGeneralQualification();
		    }
		});
		 printFinalResultList(searchItemList); 
	}
	
	public static void printSearchResultList(List<SearchItem> searchItemList, String orderBy) {
		 
		System.out.println("________Search Reasult List order by " + orderBy + "____________");
		for(int i = 0; i< searchItemList.size(); i++) {
		 System.out.println("Search Result: " + (i+1) + System.lineSeparator() + "Name : " + searchItemList.get(i).getName());
		 System.out.println("Price : " + searchItemList.get(i).getPrice());
		 System.out.println("Rating : " + searchItemList.get(i).getRating());
		 
		 }
	}
	
	public static void printFinalResultList(List<SearchItem> searchItemList) {
		 
		System.out.println("________Final Reasult List Based on Score and Cost ____________");
		for(int i = 0; i< searchItemList.size(); i++) {
		 System.out.println("Final Result: " + (i+1) + System.lineSeparator() + "Name : " + searchItemList.get(i).getName());
		 System.out.println("Price : " + searchItemList.get(i).getPrice());
		 System.out.println("Rating : " + searchItemList.get(i).getRating());
		 System.out.println("General Qualification : " + searchItemList.get(i).getGeneralQualification());
		 
		 }
	}
	
	
	

}
