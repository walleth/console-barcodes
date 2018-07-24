package org.walleth.console.barcodes

import com.google.zxing.BarcodeFormat.QR_CODE
import com.google.zxing.qrcode.QRCodeWriter

private const val WHITE_ALL = '\u2588'
private const val WHITE_BLACK = '\u2580'
private const val BLACK_WHITE = '\u2584'
private const val BLACK_ALL = ' '

fun printQR(content: String) {

    val writer = QRCodeWriter().encode(content, QR_CODE, 0, 0)

    for (y in 0 until writer.height step 2) {
        println((0 until writer.width).map { x ->
            val nextRowPixel = (y + 1 < writer.height) && writer.get(x, y + 1)
            if (writer.get(x, y)) {
                if (nextRowPixel) BLACK_ALL else BLACK_WHITE
            } else {
                if (nextRowPixel) WHITE_BLACK else WHITE_ALL
            }
        }.joinToString(""))
    }

}



