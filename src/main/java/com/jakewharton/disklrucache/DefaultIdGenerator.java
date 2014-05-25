/*
 * Copyright (C) 2012 The Android Open Source Project
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

import java.util.UUID;

/**
 * Default implementation for {@link IdGenerator}.
 */
public class DefaultIdGenerator implements IdGenerator {

  /**
   * @param key Unique non-empty key that may contain any type of character.
   * @return Concatenation the 27 last sanitized characters of the key with a generated UUID.
   */
  public String generateId(String key) {
    String lastKeyCharacters = key.length() > 27 ? key.substring(key.length() - 27, key.length()) : key;
    lastKeyCharacters = lastKeyCharacters.toLowerCase();
    lastKeyCharacters = lastKeyCharacters.replaceAll("[^a-z0-9_]", "_");
    return lastKeyCharacters + '_' + UUID.randomUUID().toString();
  }

}
