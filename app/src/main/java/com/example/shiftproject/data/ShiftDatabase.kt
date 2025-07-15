package com.example.shiftproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shiftproject.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class ShiftDatabase : RoomDatabase() {

    abstract fun shiftDao(): ShiftDao

    companion object {
        @Volatile
        private var Instance: ShiftDatabase? = null

        fun getDatabase(context: Context): ShiftDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ShiftDatabase::class.java, "shift_project")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}