package com.qrapps.QRAttendance.Utils;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;


import net.glxn.qrgen.javase.QRCode;

@Component
public class QRUtils {

	public byte[] generateQRCodeImage(String barcodeText) throws Exception {
		
		ByteArrayOutputStream stream = QRCode.from(barcodeText).withSize(250, 250).stream();
		ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());

		return IOUtils.toByteArray(bis);
	}
}
