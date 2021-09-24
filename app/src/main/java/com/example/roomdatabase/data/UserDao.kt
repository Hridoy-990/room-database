package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.model.User

@Dao
interface UserDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun addUser(user: User)
  @Update
  suspend fun updateUser(user: User)
  @Delete
  suspend fun deleteUser(user: User)
  @Query("DELETE FROM user_table")
  suspend fun deleteAllUser()
  @Query("SELECT *From user_table ORDER BY id ASC")
  fun readAllData(): LiveData <List<User>>


}