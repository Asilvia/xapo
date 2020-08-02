package com.asilvia.xapo.main.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.asilvia.xapo.R
import com.asilvia.xapo.main.viewmodel.RepositoriesItemViewModel
import com.asilvia.xapo.shared.model.Item
import kotlinx.android.synthetic.main.repositories_listitem.view.*


class RepositoriesAdapter:RecyclerView.Adapter<RepositoriesAdapter.Companion.RepositoriesViewHolder>(){

    private var list: List<Item> = emptyList()

    companion object{
        class RepositoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bindData(viewModel: RepositoriesItemViewModel){
                itemView.name.text = viewModel.repositoryName
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        // create a new view
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.repositories_listitem, parent, false)
        return RepositoriesViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.bindData(RepositoriesItemViewModel(list[position]))
    }


    override fun getItemCount() = list.size

    fun setList(newList: List<Item>){
        list = newList?: emptyList()
        notifyDataSetChanged()
    }

}