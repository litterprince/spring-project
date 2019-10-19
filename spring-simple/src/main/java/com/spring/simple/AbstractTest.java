package com.spring.simple;

import com.spring.simple.annotation.AbstractSendEmailAlarm;

/**
 * <p>Title AbstractTest </p>
 * <p> </p>
 * <p>Company: http://www.koolearn.com </p>
 *
 * @author wangzhe01@Koolearn-inc.com
 * @date 2019/10/19 11:50
 */
public abstract class AbstractTest {

    @AbstractSendEmailAlarm(titleMethodName = "title")
    public String test(){
        return abstractMethod();
    }

    abstract String abstractMethod();

    abstract String title();
}
