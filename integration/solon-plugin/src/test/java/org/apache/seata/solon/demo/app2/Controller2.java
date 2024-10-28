package org.apache.seata.solon.demo.app2;

import org.noear.solon.annotation.Body;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

import java.util.Map;

/**
 * @author noear 2024/10/28 created
 */
@Controller
public class Controller2 {
    @Mapping("user")
    public void addUser(@Body Map<String, Object> params) throws Exception {
        //..
    }

    @Mapping("order")
    public void addOrder(@Body Map<String, Object> params) throws Exception {
        //..
    }
}
