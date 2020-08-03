package com.asilvia.xapo.main.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.asilvia.xapo.R

import com.asilvia.xapo.main.viewmodel.RepositoriesItemViewModel
import com.asilvia.xapo.shared.model.Item
import kotlinx.android.synthetic.main.repositories_listitem.view.*


class RepositoriesAdapter( val onRepositoryClick: OnRepositoryClick ):RecyclerView.Adapter<RepositoriesAdapter.Companion.RepositoriesViewHolder>(){

    private var list: List<Item> = emptyList()

    companion object{
        interface OnRepositoryClick{
            fun onClick(item: Item)
        }

        class RepositoriesViewHolder(itemView: View, val clickListener: OnRepositoryClick): RecyclerView.ViewHolder(itemView), View.OnClickListener{
            override fun onClick(view: View?) {
                clickListener.onClick(itemView.tag as Item)
            }

            fun bindData(viewModel: RepositoriesItemViewModel){
                itemView.name.text = viewModel.repositoryName
                itemView.tag = viewModel.item
                itemView.setOnClickListener(this);
            }


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.repositories_listitem, parent, false)
        return RepositoriesViewHolder(itemView, onRepositoryClick)
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