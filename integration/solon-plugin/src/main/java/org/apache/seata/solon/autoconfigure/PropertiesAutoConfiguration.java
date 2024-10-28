/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.seata.solon.autoconfigure;

import org.apache.seata.solon.autoconfigure.properties.SagaAsyncThreadPoolProperties;
import org.apache.seata.solon.autoconfigure.properties.SeataProperties;
import org.apache.seata.solon.autoconfigure.properties.SeataTccProperties;
import org.apache.seata.solon.autoconfigure.properties.client.*;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;

import static org.apache.seata.solon.autoconfigure.StarterConstants.*;

/**
 * 
 * @author noear 2024/10/25 created
 * */
@Configuration
public class PropertiesAutoConfiguration {
    @Bean
    public LoadBalanceProperties loadBalanceProperties(@Inject("${" + LOAD_BALANCE_PREFIX_KEBAB_STYLE + "}") LoadBalanceProperties properties) {
        return properties;
    }

    @Bean
    public LockProperties lockProperties(@Inject("${" + LOCK_PREFIX + "}") LockProperties properties) {
        return properties;
    }

    @Bean
    public RmProperties rmProperties(@Inject("${" + CLIENT_RM_PREFIX + "}") RmProperties properties) {
        return properties;
    }

    @Bean
    public ServiceProperties serviceProperties(@Inject("${" + SERVICE_PREFIX + "}") ServiceProperties properties) {
        properties.afterPropertiesSet();
        return properties;
    }

    @Bean
    public TmProperties tmProperties(@Inject("${" + CLIENT_TM_PREFIX + "}") TmProperties properties) {
        return properties;
    }

    @Bean
    public UndoCompressProperties undoCompressProperties(@Inject("${" + COMPRESS_PREFIX + "}") UndoCompressProperties properties) {
        return properties;
    }

    @Bean
    public UndoProperties tmProperties(@Inject("${" + UNDO_PREFIX + "}") UndoProperties properties) {
        return properties;
    }

    //////////////////////

    @Bean
    public SagaAsyncThreadPoolProperties sagaAsyncThreadPoolProperties(@Inject("${" + SAGA_ASYNC_THREAD_POOL_PREFIX + "}") SagaAsyncThreadPoolProperties properties) {
        return properties;
    }

    @Bean
    public SeataProperties seataProperties(@Inject("${" + SEATA_PREFIX + "}") SeataProperties properties) {
        return properties;
    }

    @Bean
    public SeataTccProperties seataTccProperties(@Inject("${" + TCC_PREFIX + "}") SeataTccProperties properties) {
        return properties;
    }

    //////////////////////

    @Bean
    public void init() {
        PROPERTY_BEAN_MAP.put(SEATA_PREFIX, SeataProperties.class);

        PROPERTY_BEAN_MAP.put(CLIENT_RM_PREFIX, RmProperties.class);
        PROPERTY_BEAN_MAP.put(CLIENT_TM_PREFIX, TmProperties.class);
        PROPERTY_BEAN_MAP.put(LOCK_PREFIX, LockProperties.class);
        PROPERTY_BEAN_MAP.put(SERVICE_PREFIX, ServiceProperties.class);
        PROPERTY_BEAN_MAP.put(UNDO_PREFIX, UndoProperties.class);
        PROPERTY_BEAN_MAP.put(COMPRESS_PREFIX, UndoCompressProperties.class);
        PROPERTY_BEAN_MAP.put(LOAD_BALANCE_PREFIX, LoadBalanceProperties.class);
        PROPERTY_BEAN_MAP.put(SAGA_ASYNC_THREAD_POOL_PREFIX, SagaAsyncThreadPoolProperties.class);
        PROPERTY_BEAN_MAP.put(TCC_PREFIX, SeataTccProperties.class);
    }
}
