package com.spring.simple;

import com.spring.simple.annotation.OfflineMethod;
import org.springframework.stereotype.Component;

/**
 * <p>Title Test </p>
 * <p> </p>
 * <p>Company: http://www.koolearn.com </p>
 *
 * @author wangzhe01@Koolearn-inc.com
 * @date 2019/10/19 11:51
 */
public class TestAop implements InterfaceTest {
    String abstractMethod() {
        return "my abstractMethod";
    }

    String title() {
        return "my title";
    }

    @OfflineMethod
    @Override
    public void say(String words) {
        System.out.println(words);
    }
}
