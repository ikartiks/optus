package com.optus

class Group (nameX: String, descriptionX: String) {

    var id: Int = 0
    var name: String? = null
    var description: String? = null

    init{
        name= nameX
        description=descriptionX
    }
}
