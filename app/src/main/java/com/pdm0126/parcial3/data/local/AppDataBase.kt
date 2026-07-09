package com.pdm0126.parcial3.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm0126.parcial3.data.local.DAOs.OptionDao
import com.pdm0126.parcial3.data.local.DAOs.QuestionDao
import com.pdm0126.parcial3.data.local.Entity.OptionEntity
import com.pdm0126.parcial3.data.local.Entity.QuestionEntity


@Database (
    entities = [
        OptionEntity::class,
        QuestionEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase(): RoomDatabase() {

    abstract fun questionDao(): QuestionDao
    abstract fun optionDao(): OptionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = AppDatabase::class.java,
                    name = "rankeuca_database"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}