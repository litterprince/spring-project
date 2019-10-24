package com.spring.simple;

import com.spring.simple.annotation.AbstractSendEmailAlarm;
import com.spring.simple.model.SharkSaleInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * <p>Title AbstractTest </p>
 * <p> </p>
 * <p>Company: http://www.koolearn.com </p>
 *
 * @author wangzhe01@Koolearn-inc.com
 * @date 2019/10/19 11:50
 */
@Slf4j
public abstract class AbstractTest {

    @AbstractSendEmailAlarm(titleMethodName = "title")
    public String test(){
        return abstractMethod();
    }

    abstract String abstractMethod();

    abstract String title();

    public void pushDataToCrm(int userId, String productLine, int activityId, String sourceUrl){
        log.info("### pushDataToCrm coupon start! userId:{}, productLine:{}, activityId:{}, sourceUrl:{}", userId,
                productLine, activityId, sourceUrl);

        if (StringUtils.isBlank(productLine)) {
            log.info("### pushDataToCrm coupon productLine is null! productLine = ", productLine);
            return;
        }

        SharkSaleInfo sharkSaleInfo = new SharkSaleInfo();
        try {

            sharkSaleInfo.setSsoId(userId);
            sharkSaleInfo.setProductLine(Integer.valueOf(productLine));
            sharkSaleInfo.setActivityName("name");
            sharkSaleInfo.setSourceUrl(sourceUrl);
            sharkSaleInfo.setActivityType(SharkSaleInfo.ActivityTypeEnum.COUPON);

            log.info("#### pushDataToCrm coupon, sharkSaleInfo :{}", sharkSaleInfo.toString());

            log.info("### pushDataToCrm coupon success! userId:{}, productLine:{}, activityId:{}, sourceUrl:{}", userId,
                    productLine, activityId, sourceUrl);
        } catch (Exception e){
            log.error("### pushDataToCrm coupon failed!", e);
        }

        log.info("### pushDataToCrm coupon end! userId:{}, productLine:{}, activityId:{}, sourceUrl:{}", userId,
                productLine, activityId, sourceUrl);
    }
}
