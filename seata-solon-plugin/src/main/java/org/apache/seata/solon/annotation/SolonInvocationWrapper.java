package org.apache.seata.solon.annotation;

import org.apache.seata.integration.tx.api.interceptor.InvocationWrapper;
import org.noear.solon.core.aspect.Invocation;

import java.lang.reflect.Method;

/**
 * Solon invocation wrapper
 *
 * @author noear 2024/10/25 created
 */
public class SolonInvocationWrapper implements InvocationWrapper {
    private final Invocation inv;

    public SolonInvocationWrapper(Invocation inv) {
        this.inv = inv;
    }

    @Override
    public Method getMethod() {
        return inv.method().getMethod();
    }

    @Override
    public Object getProxy() {
        return inv.target();
    }

    @Override
    public Object getTarget() {
        return inv.getTargetClz();
    }

    @Override
    public Object[] getArguments() {
        return inv.args();
    }

    @Override
    public Object proceed() throws Throwable {
        return inv.invoke();
    }
}
