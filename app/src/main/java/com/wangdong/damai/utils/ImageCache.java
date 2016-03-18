package com.wangdong.damai.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 图片缓存工具类
 * @author arvin
 *
 */
public class ImageCache extends LruCache<String, Bitmap> {

	private static ImageCache imageCache;
	
	private ImageCache(int maxSize) {
		super(maxSize);
	}
	
	/*
	 *单例对象
	 */
	public static ImageCache getInstance()
	{
		if(imageCache==null){
			//得到当前应该程序的最大内存
			long maxMemory=Runtime.getRuntime().maxMemory();
			//取最大内存的1/8作为缓存的大小
			int maxSize=(int) (maxMemory/8);
			imageCache=new ImageCache(maxSize);
		}
		return imageCache;
	}
	
	
	
	

}
