package com.example.centemanagerdemo.adapter

import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.centemanagerdemo.R
import com.example.centemanagerdemo.bean.VideoDetailBean
import com.example.centemanagerdemo.utils.TimeUtils

/**
 *@author: njb
 *@date:  2023/1/16 23:36
 *@desc:
 */
class FullVideoDetailAdapter(data:MutableList<VideoDetailBean>):BaseQuickAdapter<VideoDetailBean,BaseViewHolder>(
    R.layout.item_full_video_column,data){
    override fun convert(helper: BaseViewHolder, item: VideoDetailBean) {
        item.let {
            val clFullVideo: ConstraintLayout = helper.getView(R.id.cl_full_video)
            val ivStart: ImageView = helper.getView(R.id.iv_full_play)
            val tvTime: TextView = helper.getView(R.id.tv_full_time)
            val tvContent: TextView = helper.getView(R.id.tv_full_content)
            if (!TextUtils.isEmpty(item.point.toString())) {
                tvTime.setText(TimeUtils.formatVideoTime(item.point))
            }
            tvContent.text = item.title
            addChildClickViewIds(R.id.cl_full_video,R.id.iv_full_play)
            if (item.isSelected) {
                ivStart.setImageResource(R.mipmap.icon_video_playing)
                tvTime.setTextColor(context.getColor(R.color.color_ffc10a))
                tvContent.setTextColor(context.getColor(R.color.color_ffc10a))
                clFullVideo.setBackgroundResource(R.drawable.shape_video_column_selected_bg)
            } else {
                ivStart.setImageResource(R.mipmap.icon_video_play)
                tvTime.setTextColor(context.getColor(R.color.color_white))
                tvContent.setTextColor(context.getColor(R.color.color_white))
                clFullVideo.setBackgroundResource(R.drawable.shape_full_video_bg)
            }
        }
    }
}