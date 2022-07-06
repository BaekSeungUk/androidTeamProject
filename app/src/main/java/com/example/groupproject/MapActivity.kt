package com.example.groupproject

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.groupproject.databinding.ActivityMapBinding
import com.google.android.material.navigation.NavigationBarItemView

class MapActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_map)
        val binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this,binding.drawer,R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toggle.syncState()

        val sound : MediaPlayer = MediaPlayer.create(this,R.raw.music)
        sound.start()


        val intent = Intent(this, ListActivity::class.java)
        binding.gangseo.setOnClickListener {
            intent.putExtra("location","강서구")
            startActivity(intent)
        }
        binding.sasang.setOnClickListener {
            intent.putExtra("location","사상구")
            startActivity(intent)
        }
        binding.buk.setOnClickListener {
            intent.putExtra("location","북구")
            startActivity(intent)
        }
        binding.geumjeong.setOnClickListener {
            intent.putExtra("location","금정구")
            startActivity(intent)
        }
        binding.gijang.setOnClickListener {
            intent.putExtra("location","기장군")
            startActivity(intent)
        }
        binding.busanjin.setOnClickListener {
            intent.putExtra("location","부산진구")
            startActivity(intent)
        }
        binding.dongnae.setOnClickListener {
            intent.putExtra("location","동래구")
            startActivity(intent)
        }
        binding.yeonje.setOnClickListener {
            intent.putExtra("location","연제구")
            startActivity(intent)
        }
        binding.haeundae.setOnClickListener {
            intent.putExtra("location","해운대구")
            startActivity(intent)
        }
        binding.suyeong.setOnClickListener {
            intent.putExtra("location","수영구")
            startActivity(intent)
        }
        binding.jung.setOnClickListener {
            intent.putExtra("location","중구")
            startActivity(intent)
        }
        binding.dong.setOnClickListener {
            intent.putExtra("location","동구")
            startActivity(intent)
        }
        binding.nam.setOnClickListener {
            intent.putExtra("location","남구")
            startActivity(intent)
        }
        binding.saha.setOnClickListener {
            intent.putExtra("location","사하구")
            startActivity(intent)
        }
        binding.seo.setOnClickListener {
            intent.putExtra("location","서구")
            startActivity(intent)
        }
        binding.yeongdo.setOnClickListener {
            intent.putExtra("location","영도구")
            startActivity(intent)
        }


        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("myLog","navigation item click : ${it.title}")
            val intent = Intent(this, ListActivity::class.java)
            if (it.title.equals("강서구")) {
                intent.putExtra("location","강서구")
                startActivity(intent)
            } else if (it.title.equals("사상구")) {
                intent.putExtra("location","사상구")
                startActivity(intent)
            } else if (it.title.equals("북구")) {
                intent.putExtra("location","북구")
                startActivity(intent)
            } else if (it.title.equals("금정구")) {
                intent.putExtra("location","금정구")
                startActivity(intent)
            }  else if (it.title.equals("기장군")) {
                intent.putExtra("location","기장군")
                startActivity(intent)
            } else if (it.title.equals("부산진구")) {
                intent.putExtra("location","부산진구")
                startActivity(intent)
            } else if (it.title.equals("동래구")) {
                intent.putExtra("location","동래구")
                startActivity(intent)
            } else if (it.title.equals("연제구")) {
                intent.putExtra("location","연제구")
                startActivity(intent)
            } else if (it.title.equals("해운대구")) {
                intent.putExtra("location","해운대구")
                startActivity(intent)
            } else if (it.title.equals("수영구")) {
                intent.putExtra("location","수영구")
                startActivity(intent)
            } else if (it.title.equals("중구")) {
                intent.putExtra("location","중구")
                startActivity(intent)
            } else if (it.title.equals("동구")) {
                intent.putExtra("location","동구")
                startActivity(intent)
            } else if (it.title.equals("남구")) {
                intent.putExtra("location","남구")
                startActivity(intent)
            } else if (it.title.equals("사하구")) {
                intent.putExtra("location","사하구")
                startActivity(intent)
            } else if (it.title.equals("서구")) {
                intent.putExtra("location","서구")
                startActivity(intent)
            } else if (it.title.equals("영도구")) {
                intent.putExtra("location","영도구")
                startActivity(intent)
            }
            true
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}