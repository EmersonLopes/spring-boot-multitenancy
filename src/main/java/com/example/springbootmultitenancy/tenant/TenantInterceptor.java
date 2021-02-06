package com.example.springbootmultitenancy.tenant;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class TenantInterceptor implements WebRequestInterceptor {

	private static final String TENANT_HEADER = "Filial";

	@Override
	public void preHandle(WebRequest request) {
		TenantStorage.setCurrentTenant(request.getHeader(TENANT_HEADER));
	}

	@Override
	public void postHandle(WebRequest webRequest, ModelMap modelMap) {
		TenantStorage.clear();
	}

	@Override
	public void afterCompletion(WebRequest webRequest, Exception e) {

	}
}