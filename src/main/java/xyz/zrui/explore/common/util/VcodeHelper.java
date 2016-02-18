package xyz.zrui.explore.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * 验证码工具类
 * @author zrui
 *
 */
public class VcodeHelper {
	/*
	 * 生成验证码
	 */
	public static String createVCode() {
		String code = String.format("%1$04d", (int) (Math.random() * 9999)).substring(0, 4);
		return code;
	}
	
	public static String createVCodeFor6Bit() {
		String code = String.format("%1$06d", (int) (Math.random() * 999999)).substring(0, 6);
		return code;
	}
	
	public static String createVCodeFor8Bit() {
		String code = String.format("%1$08d", (int) (Math.random() * 99999999)).substring(0, 8);
		return code;
	}
	
	public static BufferedImage createImage(String vCode){
		//验证码长度
		int codeLength = vCode.length();
		//字体大小
		int fSize = 15;
		int fWidth = fSize + 1;
		//图片宽度
		int width = codeLength * fWidth + 6;
		//图片高度
		int height = fSize * 2 + 1;
		
		//图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.createGraphics();
		//设置背景色
		g.setColor(Color.WHITE);
		//填充背景
		g.fillRect(0, 0, width, height);
		//设置边框颜色
		g.setColor(Color.LIGHT_GRAY);
		//设置字体样式
		g.setFont(new Font("Arial", Font.BOLD, height - 2));
		//绘制边框
		g.drawRect(0, 0, width - 1, height - 1);
		
		//绘制噪点
		Random r = new Random();
		//设置噪点颜色
		g.setColor(Color.LIGHT_GRAY);
		for(int i = 0; i < codeLength * 6; i++){
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			//绘制1*1大小的矩形
			g.drawRect(x, y, 1, 1);
		}
		//绘制验证码
		int codeY = height - 10;
		//设置字体颜色和样式
		g.setColor(new Color(19,148,246));
		g.setFont(new Font("Georgia", Font.BOLD, fSize));
		for(int i = 0; i < codeLength; i++){
			g.drawString(String.valueOf(vCode.charAt(i)), i * 16 + 5, codeY);
		}
		//关闭资源
		g.dispose();
		return image;
	}
	
	public static ByteArrayInputStream getImageInputStream(String vCode){
		BufferedImage image = createImage(vCode);
		return convertImageToStream(image);
	}
	
	private static ByteArrayInputStream convertImageToStream(BufferedImage image){
		ByteArrayInputStream inputStream = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(outputStream);
		try{
			jpeg.encode(image);
			byte[] bytes = outputStream.toByteArray();
			inputStream = new ByteArrayInputStream(bytes);
		}catch(ImageFormatException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
