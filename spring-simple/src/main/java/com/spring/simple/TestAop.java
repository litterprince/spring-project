package com.spring.simple;

/**
 * <p>Title Test </p>
 * <p> </p>
 * <p>Company: http://www.koolearn.com </p>
 *
 * @author wangzhe01@Koolearn-inc.com
 * @date 2019/10/19 11:51
 */
public class TestAop extends AbstractTest {
    @Override
    String abstractMethod() {
        return "my abstractMethod";
    }

    @Override
    String title() {
        return "my title";
    }
}
