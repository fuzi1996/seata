package org.apache.seata.solon.demo.main;

import org.noear.solon.Solon;

/**
 * @author noear 2024/10/28 created
 */
public class App1 {
    public static void main(String[] args) {
        Solon.start(App1.class, new String[]{"--cfg=demo/app1.yml"});
    }
}
