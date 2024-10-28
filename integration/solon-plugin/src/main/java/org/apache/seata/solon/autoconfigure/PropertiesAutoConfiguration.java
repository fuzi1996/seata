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

import static org.apache.seata.solon.autoconfigure.StarterConstants.*;

@Configuration
public class PropertiesAutoConfiguration {
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
