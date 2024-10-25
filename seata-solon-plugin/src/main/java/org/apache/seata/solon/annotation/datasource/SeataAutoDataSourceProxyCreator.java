package org.apache.seata.solon.annotation.datasource;

import org.apache.seata.core.model.BranchType;
import org.apache.seata.rm.datasource.SeataDataSourceProxy;
import org.apache.seata.rm.datasource.xa.DataSourceProxyXA;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.BeanWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;

/**
 * @author noear 2024/10/25 created
 */
public class SeataAutoDataSourceProxyCreator implements BeanWrap.Proxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(SeataAutoDataSourceProxyCreator.class);

    private final String dataSourceProxyMode;

    public SeataAutoDataSourceProxyCreator(String dataSourceProxyMode) {
        this.dataSourceProxyMode = dataSourceProxyMode;
    }

    @Override
    public Object getProxy(AppContext ctx, Object bean, Constructor beanConstructor, Object[] beanConstructorArgs) {
        // we only care DataSource bean
        if (!(bean instanceof DataSource)) {
            return bean;
        }

        // when this bean is just a simple DataSource, not SeataDataSourceProxy
        if (!(bean instanceof SeataDataSourceProxy)) {
            // else, build proxy,  put <origin, proxy> to holder and return enhancer
            DataSource origin = (DataSource) bean;
            SeataDataSourceProxy proxy = buildProxy(origin, dataSourceProxyMode);
            DataSourceProxyHolder.put(origin, proxy);
            //LOGGER.info("Auto proxy data source '{}' by '{}' mode.", beanName, dataSourceProxyMode);
            return proxy;
        }

        return bean;
    }

    SeataDataSourceProxy buildProxy(DataSource origin, String proxyMode) {
        if (BranchType.AT.name().equalsIgnoreCase(proxyMode)) {
            return new org.apache.seata.rm.datasource.DataSourceProxy(origin);
        }
        if (BranchType.XA.name().equalsIgnoreCase(proxyMode)) {
            return new DataSourceProxyXA(origin);
        }
        throw new IllegalArgumentException("Unknown dataSourceProxyMode: " + proxyMode);
    }
}
