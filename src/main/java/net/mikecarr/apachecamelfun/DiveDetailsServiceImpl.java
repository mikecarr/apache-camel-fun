package net.mikecarr.apachecamelfun;

import net.mikecarr.apachecamelfun.db.DiveDetail;
import net.mikecarr.apachecamelfun.db.DiveDetailsRepository;
import net.mikecarr.dives.DiveDetails;
import net.mikecarr.dives.DiveDetailsPort;
import net.mikecarr.dives.DiveDetailsService;
import net.mikecarr.dives.ObjectFactory;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Holder;
import java.util.*;

public class DiveDetailsServiceImpl implements DiveDetailsPort {

    private static Logger logger = LoggerFactory.getLogger(DiveDetailsServiceImpl.class);

    @Autowired
    DiveDetailsRepository diveDetailsRepository;

    @Override
    public DiveDetails getDiveDetails(int parameter) {
        Validate.notNull(parameter, "Parameter cannot be null");

        DiveDetails diveDetailsObj = new DiveDetails();
        Optional<DiveDetail> diveDetail = null;

        try {
            logger.debug("query database");
            diveDetail = diveDetailsRepository.findById(parameter);

            if(diveDetail.isPresent()) {
                logger.debug("found a value in the database!");
                BeanUtils.copyProperties(diveDetail.get(), diveDetailsObj);
            }

        } catch (BeansException e) {
            logger.error("Error retrieving DiveDetails.", e);
        }

        return diveDetailsObj;
    }
}
