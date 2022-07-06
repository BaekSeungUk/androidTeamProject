package com.example.groupproject


import com.squareup.moshi.Json

data class EmgMedResponse(
    @field:Json(name = "getFoodKr")
    val getFoodKr: GetFoodKr?
)

data class GetFoodKr(
    @field:Json(name = "header")
    val header: Header?,
    @field:Json(name = "item")
    val item: List<Item?>?,
    @field:Json(name = "numOfRows")
    val numOfRows: Int?,
    @field:Json(name = "pageNo")
    val pageNo: Int?,
    @field:Json(name = "totalCount")
    val totalCount: Int?
)

data class Header(
    @field:Json(name = "code")
    val code: String?,
    @field:Json(name = "message")
    val message: String?
)

data class Item(
    @field:Json(name = "ADDR1")
    val aDDR1: String?,
    @field:Json(name = "ADDR2")
    val aDDR2: String?,
    @field:Json(name = "CNTCT_TEL")
    val cNTCTTEL: String?,
    @field:Json(name = "GUGUN_NM")
    val gUGUNNM: String?,
    @field:Json(name = "HOMEPAGE_URL")
    val hOMEPAGEURL: String?,
    @field:Json(name = "ITEMCNTNTS")
    val iTEMCNTNTS: String?,
    @field:Json(name = "LAT")
    val lAT: Double?,
    @field:Json(name = "LNG")
    val lNG: Double?,
    @field:Json(name = "MAIN_IMG_NORMAL")
    val mAINIMGNORMAL: String?,
    @field:Json(name = "MAIN_IMG_THUMB")
    val mAINIMGTHUMB: String?,
    @field:Json(name = "MAIN_TITLE")
    val mAINTITLE: String?,
    @field:Json(name = "PLACE")
    val pLACE: String?,
    @field:Json(name = "RPRSNTV_MENU")
    val rPRSNTVMENU: String?,
    @field:Json(name = "SUBTITLE")
    val sUBTITLE: String?,
    @field:Json(name = "TITLE")
    val tITLE: String?,
    @field:Json(name = "UC_SEQ")
    val uCSEQ: Int?,
    @field:Json(name = "USAGE_DAY_WEEK_AND_TIME")
    val uSAGEDAYWEEKANDTIME: String?
)