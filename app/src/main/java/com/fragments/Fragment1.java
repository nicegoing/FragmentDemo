package com.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author puhanhui
 * @version 1.0
 * @date 2016/6/27
 * @since 1.0
 */
public class Fragment1 extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv=new TextView(getActivity());
        tv.setText(this.getClass().getCanonicalName());
        tv.setTextSize(30);

        return tv;
    }
}
