package com.dream.dp.chainOfResponsibility.webFilter;

import java.util.ArrayList;
import java.util.List;

import com.dream.dp.chainOfResponsibility.webFilter.Filter;

public class FilterChain implements Filter {
	private List<Filter> filters = new ArrayList<>();
	private int account = 0;

	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}

	@Override
	public void doFilter(Request request, Response response,
			FilterChain filterChain) {
		if(account == filters.size()) return;
		filters.get(account++).doFilter(request, response, filterChain);
	}

}
