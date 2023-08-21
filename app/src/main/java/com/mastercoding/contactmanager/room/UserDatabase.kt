package com.mastercoding.contactmanager.room

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomMasterTable

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase(){

    abstract val userDao: UserDAO

    //singleton Design Pattern
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null
            fun getInstance(context: Context): UserDatabase{
                synchronized(this){
                    var instance = INSTANCE
                    if (instance == null){
                        //creating the database
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            UserDatabase::class.java,
                            "user_db"
                        ).build()
                    }
                    return instance
                }
            }

    }

}