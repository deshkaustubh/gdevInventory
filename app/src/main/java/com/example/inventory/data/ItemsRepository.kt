/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface ItemsRepository {
    /**
     * Retrieve all the items from the given data source.
     */
    fun getAllItemsStream(): Flow<List<Item>>
    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemsStream(id: Int): Flow<Item?>
    /**
     * Insert an item into the given data source.
     */
    suspend fun insertItem(item: Item)
    /**
     * Update an item in the given data source.
     */
    suspend fun updateItem(item: Item)
    /**
     * Delete an item from the given data source.
     */
    suspend fun deleteItem(item: Item)
}
