package util;

import java.util.List;

import model.SearchItem;

public class RangeOfPrices {

	private RangeOfPrices() {
	}

	public static boolean verify(List<SearchItem> searchItemList, int lowPrice, int highPrice) {
		
		for(SearchItem searchItem :  searchItemList) {
			if(searchItem.getPrice() < lowPrice || searchItem.getPrice() > highPrice ) {
				return false;
			}
		}
		
		return true;
	}

}
