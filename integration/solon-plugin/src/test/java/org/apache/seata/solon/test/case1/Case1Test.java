package org.apache.seata.solon.test.case1;

import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Import;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2024/10/28 created
 */
@Import(profiles = "classpath:test/case1.yml")
@SolonTest
public class Case1Test {
    @Test
    public void test(){

    }
}
