package com.example.thaichana_naja.Database

import androidx.room.*

@Dao
interface ShopDao {
    @Query("SELECT * FROM Shop_list")
    fun getAll(): List<ShopEntity>

    @Query("SELECT * FROM Shop_list WHERE shopName LIKE :shopName ")
    fun findByTitle(shopName: String): ShopEntity

    @Insert
    fun insertAll(vararg todo: ShopEntity)

    @Delete
    fun delete(todo: ShopEntity)

    @Update
    fun updateTodo(vararg todos: ShopEntity)
}