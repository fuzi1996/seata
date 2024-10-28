package org.apache.seata.solon.demo.main;

import org.apache.seata.spring.annotation.GlobalTransactional;
import org.noear.solon.annotation.Body;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.net.http.HttpUtils;

import java.util.Map;

/**
 * @author noear 2024/10/28 created
 */
@Controller
public class Controller1 {
    @GlobalTransactional
    @Mapping
    public void add(@Body Map<String, Object> params) throws Exception {
        HttpUtils.http("http://localhost:8082/user")
                .data(params)
                .post();

        HttpUtils.http("http://localhost:8082/order")
                .data(params)
                .post();
    }
}
