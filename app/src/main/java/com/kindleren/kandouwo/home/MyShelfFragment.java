package com.kindleren.kandouwo.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.inject.Inject;
import com.kindleren.kandouwo.R;
import com.kindleren.kandouwo.base.BaseFragment;
import com.kindleren.kandouwo.widget.DragGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by foxcoder on 14-11-7.
 */
public class MyShelfFragment extends BaseFragment {
    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();

    @Inject
    private LayoutInflater inflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_shelf, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getView() == null) {
            return;
        }

        final DragGridView dragGridView = (DragGridView) getView().findViewById(R.id.drag_girdview);

        getMyShelfBookData();

        final ShelfBookAdapter dragAdapter = new ShelfBookAdapter(getActivity(), dataSourceList);

        dragGridView.setAdapter(dragAdapter);
        dragGridView.setOnItemClickListener(new ItemClickListener());
    }

    private void getMyShelfBookData(){
        for (int i = 0; i < 20; i++) {
            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            itemHashMap.put("item_image",R.drawable.book_one_big);
            itemHashMap.put("item_text", "宫式布局" + Integer.toString(i));
            dataSourceList.add(itemHashMap);
        }
    }

    class ItemClickListener implements AdapterView.OnItemClickListener {
        /**
         * 点击项时触发事件
         *
         * @param parent  发生点击动作的AdapterView
         * @param view 在AdapterView中被点击的视图(它是由adapter提供的一个视图)。
         * @param position 视图在adapter中的位置。
         * @param rowid 被点击元素的行id。
         */
        public void onItemClick(AdapterView<?> parent, View view, int position, long rowid) {
            HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
            //获取数据源的属性值
            String itemText=(String)item.get("itemText");
            Object object=item.get("itemImage");
            Toast.makeText(getActivity(), itemText, Toast.LENGTH_LONG).show();

//            //根据图片进行相应的跳转
//            switch (images[position]) {
//                case R.drawable.p1:
//                    startActivity(new Intent(GvActivity.this, TestActivity1.class));//启动另一个Activity
//                    finish();//结束此Activity，可回收
//                    break;
//                case R.drawable.p2:
//                    startActivity(new Intent(GvActivity.this, TestActivity2.class));
//                    finish();
//                    break;
//                case R.drawable.p3:
//                    startActivity(new Intent(GvActivity.this, TestActivity3.class));
//                    finish();
//                    break;
//            }

        }
    }
}
