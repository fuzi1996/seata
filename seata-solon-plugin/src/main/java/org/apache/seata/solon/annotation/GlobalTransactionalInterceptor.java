package org.apache.seata.solon.annotation;

import org.apache.seata.integration.tx.api.interceptor.InvocationWrapper;
import org.apache.seata.integration.tx.api.interceptor.handler.GlobalTransactionalInterceptorHandler;
import org.noear.solon.core.aspect.Interceptor;
import org.noear.solon.core.aspect.Invocation;

/**
 * @author noear 2024/10/25 created
 */
public class GlobalTransactionalInterceptor implements Interceptor {
    private final GlobalTransactionalInterceptorHandler globalTransactionalInterceptorHandler;

    public GlobalTransactionalInterceptor() {
        globalTransactionalInterceptorHandler = new GlobalTransactionalInterceptorHandler(null, null);
    }

    @Override
    public Object doIntercept(Invocation inv) throws Throwable {
        InvocationWrapper invocationWrapper = new SolonInvocationWrapper(inv);

        return this.globalTransactionalInterceptorHandler.invoke(invocationWrapper);
    }
}
