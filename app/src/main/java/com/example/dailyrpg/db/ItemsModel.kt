package com.example.dailyrpg.db
import java.util.*

data class ItemsModel(var id: Int = getAutoId(),var difficulty:Int=0,var name: String = "",var desc:String="") {
    companion object{
        fun getAutoId():Int{
            val random=Random()
            return random.nextInt(100)
        }
    }
}