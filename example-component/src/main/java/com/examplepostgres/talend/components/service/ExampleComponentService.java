package com.examplepostgres.talend.components.service;

import javax.net.ssl.SSLEngineResult.HandshakeStatus;

import com.examplepostgres.talend.components.datastore.ExamplePostgres;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.service.Service;
import org.talend.sdk.component.api.service.healthcheck.HealthCheck;
import org.talend.sdk.component.api.service.healthcheck.HealthCheckStatus;

@Service
public class ExampleComponentService {

    // you can put logic here you can reuse in components

    @HealthCheck(value = "validateConnection")
    public HealthCheckStatus healthCheck(@Option ExamplePostgres conn) {
        try{
            conn.getConection();
            return new HealthCheckStatus(HealthCheckStatus.Status.OK, "Success");
        } catch(Exception e){
            return new HealthCheckStatus(HealthCheckStatus.Status.KO, "Failed >" + e.getMessage());
        }
            
    }
    

}