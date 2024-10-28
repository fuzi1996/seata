package org.apache.seata.solon.demo.app2;

import org.noear.solon.Solon;

/**
 * @author noear 2024/10/28 created
 */
public class App2 {
    public static void main(String[] args) {
        Solon.start(App2.class, new String[]{"--cfg=demo/app2.yml"});
    }
}
