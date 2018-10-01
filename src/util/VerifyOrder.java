package util;

import java.util.List;

import model.SearchItem;

public class VerifyOrder {

	private VerifyOrder() {
	}

	public static boolean byPrice(List<SearchItem> searchItemList) {
		
		for(int i = 0; i< searchItemList.size()-1; i++) {
			  if (searchItemList.get(i).getPrice() > searchItemList.get(i+1).getPrice()) {
				  return false;
			  }	 
	    }
		return true;
		
	}

}
