package com.asilvia.xapo.main.viewmodel

import com.asilvia.xapo.shared.model.Item

class RepositoriesItemViewModel(val item: Item) {
    val repositoryName: String
        get() = item.name
}