package com.example.centemanagerdemo.bean

import java.io.Serializable

/**
 *@author: njb
 *@date:  2023/2/6 16:41
 *@desc:
 */
data class VideoDetailBean(
    var id:Int = 0,
    var title:String = "",
    var point:Int = 0,
    var url:String = "",
    var isSelected:Boolean=false
):Serializable