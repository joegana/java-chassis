/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.servicecomb.core;

import io.servicecomb.core.BootListener.BootEvent;
import io.servicecomb.core.BootListener.EventType;
import io.servicecomb.serviceregistry.RegistryUtils;
import io.servicecomb.serviceregistry.ServiceRegistry;
import io.servicecomb.serviceregistry.registry.ServiceRegistryFactory;
import mockit.Deencapsulation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSystemBootListener {

  @BeforeClass
  public static void setUp() {
    Deencapsulation.setField(SystemBootListener.class, "ready", false);
  }

  @Test
  public void testSystemBootListener() {
    SystemBootListener boot = new SystemBootListener();
    BootEvent event = new BootEvent();
    event.setEventType(EventType.AFTER_HANDLER);
    boot.onBootEvent(event);
    Assert.assertEquals(SystemBootListener.isReady(), false);

    event = new BootEvent();
    event.setEventType(EventType.AFTER_REGISTRY);
    boot.onBootEvent(event);
    Assert.assertEquals(SystemBootListener.isReady(), true);
  }
}
