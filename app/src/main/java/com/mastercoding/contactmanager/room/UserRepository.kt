package com.mastercoding.contactmanager.room

class UserRepository(private val dao: UserDAO){

    val users = dao.getAllUserInDB()

    suspend fun insert(user: User): Long{
        return dao.insertUser(user)
    }

    suspend fun update(user: User) {
        return dao.updateUser(user)
    }

    suspend fun delete(user: User){
        return dao.deleteUser(user)
    }

    suspend fun deleteAll(){
        return dao.deleteALl()
    }
}