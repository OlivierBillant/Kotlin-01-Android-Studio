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
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        PlanteDatabase::class.java,
                        "Plantation"
                    ).fallbackToDestructiveMigration().build()
//                    Si jamais je change de schéma, on change de version de database (migration)
//                    On détruira la base pour la récréer
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}