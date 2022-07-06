package com.example.groupproject

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.groupproject.databinding.ItemEmgmedBinding


class EmgMedAdapter : ListAdapter<Item, EmgMedAdapter.EmViewHolder>(EmgMedCallBack){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmViewHolder {
        val binding = ItemEmgmedBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return EmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmViewHolder, position: Int){
        holder.bind(getItem(position))
    }


    class EmViewHolder(val binding: ItemEmgmedBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item){
            with(binding){
                binding.THUM.setOnClickListener {
                    var intent = Intent(binding.MAINTITLE.context,DetailActivity::class.java)
                    intent.putExtra("image",item.mAINIMGTHUMB)
                    intent.putExtra("title",item.mAINTITLE)
                    intent.putExtra("gugunnm",item.gUGUNNM)
                    intent.putExtra("time",item.uSAGEDAYWEEKANDTIME)
                    intent.putExtra("lat","${item.lAT}")
                    intent.putExtra("lng","${item.lNG}")
                    intent.putExtra("menu",item.rPRSNTVMENU)
                    intent.putExtra("addr",item.aDDR1)
                    intent.putExtra("item",item.iTEMCNTNTS)
                    intent.putExtra("call",item.cNTCTTEL)
                    startActivity(binding.MAINTITLE.context, intent, null)
                }
                binding.MAINTITLE.setOnClickListener {
                    var intent = Intent(binding.MAINTITLE.context,DetailActivity::class.java)
                    intent.putExtra("image",item.mAINIMGTHUMB)
                    intent.putExtra("title",item.mAINTITLE)
                    intent.putExtra("gugunnm",item.gUGUNNM)
                    intent.putExtra("time",item.uSAGEDAYWEEKANDTIME)
                    intent.putExtra("lat","${item.lAT}")
                    intent.putExtra("lng","${item.lNG}")
                    intent.putExtra("menu",item.rPRSNTVMENU)
                    intent.putExtra("addr",item.aDDR1)
                    intent.putExtra("item",item.iTEMCNTNTS)
                    intent.putExtra("call",item.cNTCTTEL)

                    startActivity(binding.MAINTITLE.context, intent, null)

                }
                MAINTITLE.text = item.mAINTITLE
                GUGUNNM.text = item.gUGUNNM

                Glide.with(itemView)
                    .load(item.mAINIMGTHUMB)
                    .into(binding.THUM)
            }
        }

    }




    companion object {
        private val EmgMedCallBack = object : DiffUtil.ItemCallback<Item>(){
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

        }
    }

}