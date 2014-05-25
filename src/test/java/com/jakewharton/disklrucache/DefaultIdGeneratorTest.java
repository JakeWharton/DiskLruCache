/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jakewharton.disklrucache;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DefaultIdGeneratorTest {

  private IdGenerator idGenerator = new DefaultIdGenerator();

  @Test public void generateIdWithSimpleKey() {
    String id = idGenerator.generateId("abc123");
    assertThat(id).matches("abc123_[a-z0-9]{8}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{12}");
  }

  @Test public void generateIdWithComplexKey() {
    String id = idGenerator.generateId("abcABC123,?;.:/!§ \n\t\"\r\\&@m");
    System.out.println(id);
    assertThat(id).matches("abcabc123________________m_[a-z0-9]{8}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{12}");
  }

  @Test public void generateIdWithLongKey() {
    String id = idGenerator.generateId("abcdefghijklmnopqrstuvwxyz0123456789");
    System.out.println(id);
    assertThat(id).matches("jklmnopqrstuvwxyz0123456789_[a-z0-9]{8}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{12}");
  }
}
