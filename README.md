Disk LRU Cache
==============
Disk lru cache forked from [JakeWharthon DiskLruCache][jakeLru]</br>

Create additional get(String key, boolean accessOrder) method to have option to ignore reordering during access

Download
========

Grab via Gradle:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

implementation 'com.github.kelvinc1024:DiskLruCache:master-SNAPSHOT'


```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

If you would like to compile your own version, the library can be built by
running `mvn clean verify`. The output JAR will be in the `target/` directory.
*(Note: this requires Maven be installed)*



License
=======

    Copyright 2012 Jake Wharton
    Copyright 2011 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [jar]: https://search.maven.org/remote_content?g=com.jakewharton&a=disklrucache&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
 [jakeLru]: https://github.com/JakeWharton/DiskLruCache