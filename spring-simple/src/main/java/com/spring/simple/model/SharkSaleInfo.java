package com.spring.simple.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>Title SharkSaleInfo </p>
 * <p> </p>
 * <p>Company: http://www.koolearn.com </p>
 *
 * @author wangzhe01@Koolearn-inc.com
 * @date 2019/10/24 13:06
 */
@Data
@ToString
public class SharkSaleInfo implements Serializable {
    /**
     * 用户名  用户名和ssoId必传其一
     */
    private String userName;
    /**
     * 注册手机号
     */
    private String phone;
    /**
     * ssoId
     */
    private int ssoId;
    /**
     * 产品分组
     */
    private int productGroup;
    /**
     * 产品分组名称
     */
    private String productGroupName;
    /**
     * 产品线
     */
    private int productLine;
    /**
     * 定金Id
     */
    private int depositId;
    /**
     * 来源页
     */
    private String sourceUrl;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 事业部id
     */
    private int bizId;
    /**
     * 事业部名称
     */
    private String bizName;
    /**
     * 活动类型 必填 {@link ActivityTypeEnum}
     *
     */
    private ActivityTypeEnum activityType;

    public enum ActivityTypeEnum {

        /**
         * 优惠券
         */
        COUPON,
        /**
         * 活动
         */
        DEPOSIT
    }

}
