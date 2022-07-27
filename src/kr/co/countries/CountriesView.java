package kr.co.countries;

import java.util.ArrayList;

public class CountriesView {

	public void view(CountriesDTO countriesDTO) {
		System.out.println("국가코드 : " + countriesDTO.getCountry_id() + "  국가명 : " + countriesDTO.getCountry_name() + "  대륙코드 : " + countriesDTO.getRegion_id());
	}
	
	public void view(ArrayList<CountriesDTO> results) {
		for(CountriesDTO country : results) {
			System.out.println("국가코드 : " + country.getCountry_id() + "  국가명 : " + country.getCountry_name() + "  대륙코드 : " + country.getRegion_id());
		}
	}
	
}
