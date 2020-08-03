package com.asilvia.xapo.main.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel;
import com.asilvia.xapo.shared.model.Item

class DetailsViewModel : ViewModel() {
    var repository: Item? = null
    fun dispatch(args: Bundle?){
        repository = args?.getParcelable("item") as Item
    }

    fun getName() = repository?.name


}
