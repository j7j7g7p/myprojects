package com.dream.dp.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

import com.dream.dp.chainOfResponsibility.Filter;

public class FilterChain implements Filter{
	private List<Filter> filters = new ArrayList<>();
	
	public FilterChain addFilter(Filter filter){
		filters.add(filter);
		return this;
	}
	@Override
	public String doFilter(String target) {
		String result = target;
		for(Filter filter:filters){
			result = filter.doFilter(result);
		}
		return result;
	}

}
