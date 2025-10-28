package com.example.lab_4.data.database

import android.util.Log
import androidx.compose.foundation.layout.add
import com.example.lab_4.domain.Chiuit
import com.example.lab_4.domain.ChiuitRepository

class ChiuitDbStore(private val appDatabase: AppDatabase) : ChiuitRepository {

    override fun getAll(): List<Chiuit> {
        return appDatabase.chiuitDao().getAll().map { it.toDomainModel() }
    }

    override fun addChiuit(chiuit: Chiuit) {
        // TODO 2: Add the new chiuit by invoking the DAO; make sure to use the designated mapper.

        // 1. Converteste obiectul 'Chiuit' (domain) la 'ChiuitEntity' (database) folosind mapper-ul.
        val chiuitEntity = chiuit.toDbModel()

        // 2. Apelează DAO-ul pentru a insera entitatea în baza de date.
        appDatabase.chiuitDao().add(chiuitEntity)
    }

    override fun removeChiuit(chiuit: Chiuit) {
        // TODO 5: Remove the chiuit by invoking the DAO; make sure to use the designated mapper.
    }


    private fun Chiuit.toDbModel() = ChiuitEntity(timestamp, description)

    private fun ChiuitEntity.toDomainModel() = Chiuit(timestamp, description)

}