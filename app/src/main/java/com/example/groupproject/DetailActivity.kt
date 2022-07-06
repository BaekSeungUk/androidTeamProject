package com.example.groupproject


import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.groupproject.databinding.ActivityDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_detail.*



class DetailActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    lateinit var title: String
    lateinit var gugunnm: String
    lateinit var lat: String
    lateinit var lng: String
    lateinit var image: String
    lateinit var uSAGEDAYWEEKANDTIME: String
    lateinit var rPRSNTVMENU: String
    lateinit var aDDR1: String
    lateinit var iTEMCNTNTS: String
    lateinit var cNTCTTEL: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map)  as SupportMapFragment
        mapFragment.getMapAsync(this)

        val intent = getIntent()

        image = intent.getStringExtra("image").toString()
        title = intent.getStringExtra("title").toString()
        gugunnm = intent.getStringExtra("gugunnm").toString()
        lat = intent.getStringExtra("lat").toString()
        lng = intent.getStringExtra("lng").toString()
        uSAGEDAYWEEKANDTIME = intent.getStringExtra("time").toString()
        rPRSNTVMENU = intent.getStringExtra("menu").toString()
        aDDR1 = intent.getStringExtra("addr").toString()
        iTEMCNTNTS = intent.getStringExtra("item").toString()
        cNTCTTEL = intent.getStringExtra("call").toString()


        MAIN_TITLE.text = "가게 이름 : ${title}"
        GUGUN_NM.text = "${gugunnm}"
        time.text = "영업 시간 : ${uSAGEDAYWEEKANDTIME}"
        menu.text = "대표 메뉴 : ${rPRSNTVMENU}"
        addr.text = "주소 : ${aDDR1}"
        ex.text = "상세 설명 :${iTEMCNTNTS}"
        call.text = "연락처 : ${cNTCTTEL}"
        Glide.with(this)
            .load(image)
            .into(binding.image)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        lat = intent.getStringExtra("lat").toString()
        lng = intent.getStringExtra("lng").toString()


        val sydney = LatLng("${lat}".toDouble(),"${lng}".toDouble())
        mMap.addMarker(MarkerOptions()
            .position(sydney)
            .title("${title}"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15F))


    }
}