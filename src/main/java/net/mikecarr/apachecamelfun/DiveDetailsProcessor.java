package net.mikecarr.apachecamelfun;

import net.mikecarr.apachecamelfun.db.DiveDetailsRepository;
import net.mikecarr.dives.DiveDetails;
import net.mikecarr.dives.DiveDetailsPort;
import net.mikecarr.dives.DiveDetailsService;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DiveDetailsProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(DiveDetailsProcessor.class);

    @Autowired
    DiveDetailsPort diveDetailsService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Message inMessage = exchange.getIn();
        String operationName = inMessage.getHeader(CxfConstants.OPERATION_NAME, String.class);

        if(operationName.equals("GetDiveDetails")) {
            Integer diveId = inMessage.getBody(Integer.class);
            DiveDetails response = diveDetailsService.getDiveDetails(diveId);


            exchange.getOut().setBody(response);
        }


    }
}
