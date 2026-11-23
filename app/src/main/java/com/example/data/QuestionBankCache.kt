package com.example.data

import java.util.LinkedHashMap

/**
 * Bounded, thread-safe LRU cache for curriculum question banks.
 *
 * Prevents eager loading of all 45+ subject question banks into heap memory on app startup.
 * Keeps at most [MAX_CACHED_BANKS] recently accessed banks resident in RAM and supports
 * immediate eviction under Android memory pressure via [clear].
 */
object QuestionBankCache {

    const val MAX_CACHED_BANKS = 3

    private val cache: LinkedHashMap<String, List<QuestionModel>> =
        object : LinkedHashMap<String, List<QuestionModel>>(8, 0.75f, true) {
            override fun removeEldestEntry(
                eldest: MutableMap.MutableEntry<String, List<QuestionModel>>?
            ): Boolean = size > MAX_CACHED_BANKS
        }

    @Synchronized
    fun getOrLoad(key: String, loader: () -> List<QuestionModel>): List<QuestionModel> {
        cache[key]?.let { return it }
        val loaded = loader()
        cache[key] = loaded
        return loaded
    }

    @Synchronized
    fun clear() {
        cache.clear()
    }

    @Synchronized
    fun cachedBankCount(): Int = cache.size

    @Synchronized
    fun cachedKeys(): Set<String> = cache.keys.toSet()
}
