package com.example.thaichana_naja.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Shop_list")
data class ShopEntity(
    @PrimaryKey
    @ColumnInfo(name = "shopId") val shopId: String,
    @ColumnInfo(name = "shopName") val shopName: String,
    @ColumnInfo(name = "appId") val appId: String,
    @ColumnInfo(name = "subcategory") val subcategory: String,
    @ColumnInfo(name = "businessType") val businessType: String
)
