package com.spring.simple;

import lombok.extern.slf4j.Slf4j;

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

    public String test(){
        return abstractMethod();
    }

    abstract String abstractMethod();

    abstract String title();
}
