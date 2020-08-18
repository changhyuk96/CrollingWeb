package com.my.crolling;

import java.util.Comparator;

public class ListComparator implements Comparator<CityInfo>{
	
	@Override
	public int compare(CityInfo o1, CityInfo o2) {
		
		int todayTotal1 = Integer.parseInt(((CityInfo)o1).getTodayTotal());
		int todayTotal2 = Integer.parseInt(((CityInfo)o2).getTodayTotal());
		
        if(todayTotal1 > todayTotal2){
            return -1;
        }else if(todayTotal1 < todayTotal2){
            return 1;
        }else{
            return 0;
        }
	}
}
