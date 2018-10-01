package util;

import java.util.List;

import model.SearchItem;

public class RecommendItem {
	
	public static void calculate(List<SearchItem> searchItemList) {
		
		SortResultsList.byRating(searchItemList, false);
		for(int i = 0; i< searchItemList.size(); i++) {
			  searchItemList.get(i).setRatingPosition(i+1);
	    }
		
		SortResultsList.byPrice(searchItemList, false);
		for(int i = 0; i< searchItemList.size(); i++) {
			  searchItemList.get(i).setPricePosition(i+1);
	    }
		for(SearchItem searchItem :  searchItemList) {
			searchItem.setGeneralQualification(searchItem.getPricePosition() + searchItem.getRatingPosition());
		}
		
		SortResultsList.byGeneralQualification(searchItemList);
	}

}
