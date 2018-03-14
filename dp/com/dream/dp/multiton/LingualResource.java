package com.dream.dp.multiton;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class LingualResource {
	private String language = "en";
	private String region = "US";
	private String localeCode = "en_US";
	private static final String FILE_NAME = "res";

	private static HashMap instance = new HashMap<>(19);

	private Locale locale = null;
	
	private ResourceBundle resourceBundle = null;
	
	private LingualResource() {}
	
	private LingualResource(String language, String region) {
		this.language = language;
		this.region = region;
		localeCode = language + "_" + region;
		locale = new Locale(language, region);
		resourceBundle = ResourceBundle.getBundle(LingualResource.FILE_NAME, locale);
		instance.put(localeCode, resourceBundle);
	}
	public static LingualResource getInstance(String language, String region) {
		String localeCode = language+"_"+region;
		if (instance.get(language) == null) {
			return new LingualResource(language, region);
		}
		return (LingualResource) instance.get(localeCode);
	}
	public String getLocaleString(String code){
		return resourceBundle.getString(code);
	}
	public static void main(String[] args) {
		LingualResource lingualResource = LingualResource.getInstance("en", "US");
		String usDollar = lingualResource.getLocaleString("USD");
		System.out.println("USD="+usDollar);
		LingualResource lingualResourceZH = LingualResource.getInstance("zh", "CH");
		String usDollarZH = lingualResourceZH.getLocaleString("USD");
		System.out.println("USD="+usDollarZH);
	}
}
