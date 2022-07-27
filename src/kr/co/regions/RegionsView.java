package kr.co.regions;

import java.util.ArrayList;

public class RegionsView {

	//view
	public void view(RegionsDTO regionsDTO) {
		System.out.println("대륙코드 : " + regionsDTO.getRegion_id() + "  대륙명 : " + regionsDTO.getRegion_name());
	}
	
	public void view(ArrayList<RegionsDTO> regionsResults) {
		for(RegionsDTO result : regionsResults) {
			System.out.println("대륙코드 : " + result.getRegion_id() + "  대륙명 : " + result.getRegion_name());
		}
	}
	
}
