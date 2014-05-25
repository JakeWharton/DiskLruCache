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
 * Generate an unique ID in the format `[a-z0-9_-]{1,64}` based on an unique key.
 */
public interface IdGenerator {

  /**
   * @param key Unique non-empty key that may contain any type of character.
   * @return Unique ID in the format `[a-z0-9_-]{1,64}`.
   */
  String generateId(String key);

}
