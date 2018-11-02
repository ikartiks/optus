package com.optus.pojos

class Result {
    var id: Int = 0

    var name: String? = null

    var fromcentral: Fromcentral? = null

    var location: Location? = null

    override fun toString(): String {
        return ""+this?.name
    }
}
