package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // if the instance is not null, return it, otherwise create a new instance
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it } // save the instance to the variable
            }
        }
    }
}

/*
Tip: You can use this code as a template for your future projects. The way you create the RoomDatabase instance is similar to the process in the previous steps. You might have to replace the entities and DAOs specific to your app.
 */