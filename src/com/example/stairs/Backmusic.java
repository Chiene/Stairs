package com.example.stairs;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Backmusic extends Service{
	
	private MediaPlayer mp;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override 

	public void onStart(Intent intent, int startId) { 
		
		// �}�l���񭵼� 
		mp.start();
		
		// ���ּ��񧹲����ƥ�B�z
		mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				
				//�`������
				try { 

					mp.start(); 

					} catch (IllegalStateException e) { 

					// TODO Auto-generated catch block 

					e.printStackTrace(); 

					} 
				
			}
			
		});
		
		// ���񭵼֮ɵo�Ϳ��~���ƥ�B�z
		mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				// TODO Auto-generated method stub
				
				// ����귽
				try { 

					mp.release(); 

					} catch (Exception e) { 

					e.printStackTrace(); 

					} 
				return false;
			} 
			
		});
		
		super.onStart(intent, startId); 
	}
	
	@Override 

	public void onCreate() { 
		
		try {
			// ��l�ƭ��ָ귽 
			
			// �Ы�MediaPlayer��H 
			mp = new MediaPlayer(); 
			
			// �N���֫O�s�bres/raw/backgroundmusic
			mp = MediaPlayer.create(Backmusic.this,R.raw.backgroundmusic);
			
			// �bMediaPlayer���o����귽�Pstop()����n�ǳ�PlayBack�����A�e�@�w�n�ϥ�MediaPlayer.prepeare
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.onCreate();
	}
	
	@Override

	public void onDestroy() {
		// �A�Ȱ���ɰ���񭵼֨�����귽

		mp.stop();

		mp.release();


		super.onDestroy();
	}
}
