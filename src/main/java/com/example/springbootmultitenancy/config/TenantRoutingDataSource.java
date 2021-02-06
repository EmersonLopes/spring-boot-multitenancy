package com.example.springbootmultitenancy.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.example.springbootmultitenancy.tenant.TenantStorage;

public class TenantRoutingDataSource extends AbstractRoutingDataSource {
	 
    @Override
    protected Object determineCurrentLookupKey() {
        return TenantStorage.getCurrentTenant();
    }
 
}
