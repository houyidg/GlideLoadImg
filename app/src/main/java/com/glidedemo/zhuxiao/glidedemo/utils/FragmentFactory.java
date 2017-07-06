package com.glidedemo.zhuxiao.glidedemo.utils;

import android.util.SparseArray;

import com.glidedemo.zhuxiao.glidedemo.fragment.FragmentTemplate;

import java.lang.ref.SoftReference;

/**
 * Created by zhuxiao on 2016/5/10.
 */
public class FragmentFactory {
    private static FragmentFactory ourInstance = new FragmentFactory();
    SparseArray<SoftReference<FragmentTemplate>> fragmentMap;
    public static FragmentFactory getInstance() {
        return ourInstance;
    }

    private FragmentFactory() {
        fragmentMap = new SparseArray<SoftReference<FragmentTemplate>>();
    }

    public FragmentTemplate findFragmentByLayoutId(int id){
        SoftReference<FragmentTemplate> fragment = fragmentMap.get(id);
        if(fragment==null || fragment.get()==null){
            FragmentTemplate instance = FragmentTemplate.newInstance(id);
            fragment = new SoftReference<FragmentTemplate>(instance);
            fragmentMap.put(id,fragment);
        }
        return fragment.get();
    }
}
