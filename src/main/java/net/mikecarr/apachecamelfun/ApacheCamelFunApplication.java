package net.mikecarr.apachecamelfun;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheCamelFunApplication extends RouteBuilder {

	public static void main(String[] args) {

		SpringApplication.run(ApacheCamelFunApplication.class, args);
	}

	@Override
	public void configure() throws Exception {

		from("cxf:bean:diveDetailsServiceEndpoint")
                .routeId("GetDiveDetailsSoap")
				//from("cxf:/CustomerServicePort?serviceClass=" + CustomerService.class.getName())
				.to("DiveDetailsProcessor");
	}
}
