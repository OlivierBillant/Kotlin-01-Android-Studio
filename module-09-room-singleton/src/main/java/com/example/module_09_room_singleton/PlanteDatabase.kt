package com.example.module_09_room_singleton

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Plante::class], version = 1)
abstract class PlanteDatabase : RoomDatabase() {
    abstract fun planteDao(): PlanteDao

    companion object {
        @Volatile
        private var INSTANCE: PlanteDatabase? = null

        fun getInstance(context: Context): PlanteDatabase {
            synchronized(this) {
                var instace = INSTANCE
                if (instace == null) {
                    instace = Room.databaseBuilder(
                        context,
                        PlanteDatabase::class.java,
                        "Plantation"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instace
                }
                return instace
            }
        }
    }
}