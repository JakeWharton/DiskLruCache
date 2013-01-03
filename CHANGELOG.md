Change Log
==========

Version 1.3.1 *(2013-01-02)*
----------------------------

 * Fix: Correct logic around detecting whether a journal rebuild is required.
   *(Thanks Jonathan Gerbaud)*


Version 1.3.0 *(2012-12-24)*
----------------------------

 * Re-allow dash in cache key (now `[a-z0-9_-]{1,64}`).
 * New: `getLength` method on `Snapshot`. *(Thanks Edward Dale)*
 * Performance improvements reading journal lines.


Version 1.2.1 *(2012-10-08)*
----------------------------

 * Fix: Ensure library references Java 5-compatible version of
   `Arrays.copyOfRange`. *(Thanks Edward Dale)*


Version 1.2.0 *(2012-09-30)*
----------------------------

 * New API for cache size adjustment.
 * Keys are now enforced to match `[a-z0-9_]{1,64}` *(Thanks Brian Langel)*
 * Fix: Cache will gracefully recover if directory is deleted at runtime.


Version 1.1.0 *(2012-01-07)*
----------------------------

 * New API for editing an existing snapshot. *(Thanks Jesse Wilson)*


Version 1.0.0 *(2012-01-04)*
----------------------------

Initial version.
