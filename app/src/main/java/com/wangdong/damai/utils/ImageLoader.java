package com.wangdong.damai.utils;

import java.io.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * 加载图片
 * 
 * @author arvin
 *
 */
public class ImageLoader {

	/**
	 * 图片加载的方法
	 */

	public static void loadImage(String path, ImageView imageView) {
		 System.out.println("------"+path);
		if (path.equals("") || path == null) {
			System.out.println("-----地址不正确");
		} else {
			// 1,在缓存中找
			Bitmap bmp = ImageCache.getInstance().get(path);
			if (bmp == null) {
				// 如果缓存中没有 开启线程在文件系统中找
				File file = CacheFileUtils.getCacheFile(path);
				if (file == null) {
					// 如果文件 系统中没有
					// 开启异步任务到网络下载 下载 完成之后保存到文件 系统 ，放到缓存里面
					new ImagesTask(imageView).execute(path);
				} else // 说明文件 系统中有
				{
					bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
					// 把他放到缓存里面
					ImageCache.getInstance().put(path, bmp);
					// 把图片显示到ImageView 里面
					imageView.setImageBitmap(bmp);
				}

			} else {
				imageView.setImageBitmap(bmp);
			}
		}
	}

	static class ImagesTask extends AsyncTask<String, Void, Bitmap> {
		private ImageView imageView;
		private String path;

		public ImagesTask(ImageView imageView) {
			this.imageView = imageView;
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			path = params[0];
			return HttpUtils.getImage(params[0]);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			if (result != null) {
				// 保存到文件系统中
				CacheFileUtils.saveCacheFile(path, result);
				// 保存到缓存中
				ImageCache.getInstance().put(path, result);
				// 显示到ImageView里面
				this.imageView.setImageBitmap(result);
			}

		}
	}
}
