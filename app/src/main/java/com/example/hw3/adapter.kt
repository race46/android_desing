package com.example.hw3

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3.databinding.RecyclerViewItemBinding
import kotlin.math.absoluteValue

class recycler_adapter(private val dataSet: Array<String>, private val context: Context) :
    RecyclerView.Adapter<recycler_adapter.ViewHolder>() {

    private val data = BooleanArray(dataSet.size)

    class ViewHolder(val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //if(viewType == 1) return ViewHolder(RecyclerItemBottomBinding.inflate(LayoutInflater.from(parent.context),parent,false))

        return ViewHolder(
            RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(position < dataSet.size) {


            val res = context.resources


            val str = res.getIdentifier("mid", "string", context.packageName)
            val name = res.getString(str)
            val mid = res.getIdentifier(name, "drawable", context.packageName)

            val str_br = res.getIdentifier("mid_brk", "string", context.packageName)
            val name_br = res.getString(str_br)
            val mid_br = res.getIdentifier(name_br, "drawable", context.packageName)


            if (data[position]) {
                holder.binding.imageleft.setImageResource(mid)
                holder.binding.imageright.setImageResource(mid)
                holder.binding.divider.setBackgroundColor(Color.GREEN)
                holder.binding.textview.setShadowLayer(50f, 0f, 0f, Color.GREEN)
            } else {
                holder.binding.imageleft.setImageResource(mid_br)
                holder.binding.imageright.setImageResource(mid_br)
                holder.binding.divider.setBackgroundColor(Color.RED)
                holder.binding.textview.setShadowLayer(50f, 0f, 0f, Color.RED)
            }

            holder.binding.layout.setOnClickListener {
                data[position] = !data[position]
                notifyItemChanged(position)
                notifyItemChanged(dataSet.size)
            }


            holder.binding.textview.text = dataSet[position]
        }else if(position == dataSet.size){
            val res = context.resources

            val str = res.getIdentifier("mid", "string", context.packageName)
            val name = res.getString(str)
            val mid = res.getIdentifier(name, "drawable", context.packageName)

            holder.binding.imageleft.setImageResource(mid)
            holder.binding.imageright.setImageResource(mid)

            holder.binding.textview.text = "Hayallerin"
            var all = true
            for(i in data) all = i && all

            if(all){
                holder.binding.divider.setBackgroundColor(Color.GREEN)
                holder.binding.textview.setShadowLayer(50f, 0f, 0f, Color.GREEN)

            }else {
                holder.binding.divider.setBackgroundColor(Color.RED)
                holder.binding.textview.setShadowLayer(50f, 0f, 0f, Color.RED)

            }


        }else{
            holder.binding.layout.setBackgroundResource(R.drawable.su)
            holder.binding.textview.text = ""
            holder.binding.imageright.visibility = View.INVISIBLE
            holder.binding.imageleft.visibility = View.INVISIBLE

        }


    }

    override fun getItemCount() = dataSet.size + 2

    override fun getItemViewType(position: Int) = (position + 1) / dataSet.size
}