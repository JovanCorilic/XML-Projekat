package com.xml.zig.zigbackapp.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.commons.text.StringEscapeUtils;
//import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Component
public class QRCodeGenerator {

	
	public String getQRCodeAsByteArray(String full_url) {
		
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		
		BitMatrix bitMatrix;
		
		try {
			
			bitMatrix = qrCodeWriter.encode(full_url, BarcodeFormat.QR_CODE, 250, 250);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			MatrixToImageWriter.writeToStream(bitMatrix, "JPEG", baos);
			
//			System.out.println(new String(baos.toByteArray(), StandardCharsets.UTF_8));
			
			String image = Base64.getEncoder().encodeToString(baos.toByteArray());
			
//			System.out.println(image);
//			String pic = new String(baos.toByteArray(), StandardCharsets.UTF_8);
			
//			StringEscapeUtils.escapeXml10(pic);
			
//			String escaape_pic = StringEscapeUtils.escapeXml10(pic);
			
			String image_html = "data:image/jpeg;base64," + image;
			
			return image_html;
			
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		BitMatrix bitMatrix = qrCodeWriter.encode(full_url, BarcodeFormat.QR_CODE, 250, 250);
		
		return "EMPTY";
		
	}
	
}
