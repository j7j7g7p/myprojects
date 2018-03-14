package com.dream.dp.proxy.smartReference;

public class Proxy implements Searcher {
	private RealSearcher searcher = new RealSearcher();
	private AccessCheck check = new AccessCheck();
	private UsageLogger log = new UsageLogger();

	@Override
	public String doSearch(String id, String type) {
		String validresult = check.check(id);
		String result = "";
		if ("yes".equals(validresult)) {
			log.info(id, type);
			result = searcher.doSearch(id, type);
		}
		return result;
	}

}
