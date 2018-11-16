package net.mikecarr.apachecamelfun;

import net.mikecarr.dives.DiveDetails;
import net.mikecarr.dives.DiveDetailsPort;
import net.mikecarr.dives.DiveDetailsService;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.camel.component.cxf.CxfEndpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    //NOTE THE VALUE OF cxf.path in application.properties this leads to
    //the URL of the soap service being of the form /service/CustomerServicePort

    @Bean(name="DiveDetailsProcessor")
    public DiveDetailsProcessor getProcessor(){
        return new DiveDetailsProcessor();
    }

    @Bean
    public CxfEndpoint diveDetailsServiceEndpoint() {

        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("/DiveDetailsPort");
        //cxfEndpoint.setServiceNameString("s:divedetails:diveDetailsServiceService");
        cxfEndpoint.setServiceClass(DiveDetailsPort.class);
        cxfEndpoint.setBus(bus);
        return cxfEndpoint;
    }

    @Bean
    public DiveDetailsPort diveDetailsService()
    {
        return new DiveDetailsServiceImpl();
    }
}
