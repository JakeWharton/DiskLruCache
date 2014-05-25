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

/**
 * Generate IDs in a predictable way in order to be able to easily test the {@link com.jakewharton.disklrucache.DiskLruCache}.
 */
public class PredictableIdGenerator implements IdGenerator {

  private final String uuid;

  /**
   * Create an {@link com.jakewharton.disklrucache.IdGenerator} that will always use the same UUID.
   *
   * @param uuid UUID used to generate IDs
   */
  public PredictableIdGenerator(String uuid) {
    this.uuid = uuid;
  }

  /**
   * Generate IDs in a similar way as {@link DefaultIdGenerator} but with a provided UUID.
   */
  public String generateId(String key) {
    String lastKeyCharacters = key.length() > 27 ? key.substring(key.length() - 27, key.length()) : key;
    lastKeyCharacters = lastKeyCharacters.toLowerCase();
    lastKeyCharacters = lastKeyCharacters.replaceAll("[^a-z0-9_]", "_");
    return lastKeyCharacters + '_' + uuid;
  }

}
