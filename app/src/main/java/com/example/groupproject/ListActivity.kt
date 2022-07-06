package com.example.groupproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groupproject.databinding.ActivityListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var location: String
    private val binding: ActivityListBinding by lazy {
        ActivityListBinding.inflate(layoutInflater)
    }

    private val emgMedAdapter by lazy {
        EmgMedAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this,binding.drawer,R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toggle.syncState()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = emgMedAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        val intent = getIntent()
        location = intent.getStringExtra("location").toString()

        retrofitWork(location)

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

    private fun retrofitWork(location: String) {
        val service = RetrofitApi.emgMedService

        service.getEmgMedData(getString(R.string.api_key), "1", "150", "json", "영도구")
            .enqueue(object : Callback<EmgMedResponse> {
                override fun onResponse(
                    call: Call<EmgMedResponse>,
                    response: Response<EmgMedResponse>,
                ) {
                    if (response.isSuccessful) {
                        Log.d("TAG", response.body().toString())
                        val result = response.body()?.getFoodKr?.item
                        var result2 = mutableListOf<Item>()

                        if (result != null) {
                            Log.d("myLog", "result size : ${result.size}")
                            for (i in 0..(result.size - 1)) {
                                if (this@ListActivity.location == result.get(i)?.gUGUNNM) {
                                    Log.d("myLog", "location ${result.get(i)}")
                                    result2.add(result.get(i)!!)
                                }
                            }
                        }
                        emgMedAdapter.submitList(result2!!)
                    }
                }

                override fun onFailure(call: Call<EmgMedResponse>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }
}