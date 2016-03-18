package com.wangdong.damai.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * 请求网络工具
 * 
 * @author arvin
 *
 */
public class HttpUtils {

	/**
	 * 请求字符串
	 */
	public static String getString(String path) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String temp = "";
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 下载图片
	 */

	public static Bitmap getImage(String path) {
		Bitmap bmp = null;
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			bmp=BitmapFactory.decodeStream(conn.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bmp;
	}

}
