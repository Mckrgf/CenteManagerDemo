package com.example.centemanagerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.centemanagerdemo.adapter.FullVideoDetailAdapter
import com.example.centemanagerdemo.bean.VideoDetailBean
import com.example.centemanagerdemo.decoration.SpacesItemDecoration
import com.example.centemanagerdemo.manager.CenterLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var centerAdapter: FullVideoDetailAdapter? = null
    private var dataList: MutableList<VideoDetailBean>? = null
    private var centerLayoutManager: CenterLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
    }

    private fun initAdapter() {
        dataList = mutableListOf()
        for (i in 0..20) {
            val detailModel = VideoDetailBean()
            detailModel.title = ("S1 与 Vision+ S1 App 的连接S1")
            detailModel.point = (90)
            dataList?.add(detailModel)
        }
        centerAdapter = FullVideoDetailAdapter(dataList!!)
        centerLayoutManager = CenterLayoutManager(this,RecyclerView.HORIZONTAL,false)
        rv_video.layoutManager = centerLayoutManager
        rv_video.addItemDecoration(SpacesItemDecoration(20, 0))
        rv_video.adapter = centerAdapter

        centerAdapter?.setOnItemChildClickListener { adapter, view, position ->
            val list: MutableList<VideoDetailBean> = adapter.data as MutableList<VideoDetailBean>
            for (videoDetailModel in list) {
                videoDetailModel.isSelected = false
            }
            list[position].isSelected = true
            centerAdapter?.notifyDataSetChanged()
            if (view.id == R.id.iv_full_play || view.id == R.id.cl_full_video) {
                if (dataList != null && dataList?.size!! > 3) {
                    centerLayoutManager!!.smoothScrollToPosition(
                        rv_video,
                        RecyclerView.State(),
                        position
                    )
                }
            }
        }
    }
}