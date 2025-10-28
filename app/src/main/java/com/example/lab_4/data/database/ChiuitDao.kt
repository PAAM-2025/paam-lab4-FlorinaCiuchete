package com.example.lab_4.data.database
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lab_4.domain.Chiuit


@Dao
interface ChiuitDao {

    @Query("SELECT * FROM chiuits")
    fun getAll(): List<ChiuitEntity>
    // TODO 3: Define the insert operation.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(chiuitEntity: ChiuitEntity)


    // TODO 6: Define the delete operation.

}