package org.walleth.console.barcodes

import com.google.zxing.BarcodeFormat.QR_CODE
import com.google.zxing.qrcode.QRCodeWriter

private const val WHITE_ALL = '\u2588'
private const val WHITE_BLACK = '\u2580'
private const val BLACK_WHITE = '\u2584'
private const val BLACK_ALL = ' '

fun printQR(content: String) {

    val writer = QRCodeWriter().encode(content, QR_CODE, 0, 0)

    (0 until writer.height step 2).forEach { y ->
        println((0 until writer.width).map { x ->
            val next = (y + 1 < writer.height) && writer.get(x, y + 1)
            if (writer.get(x, y)) {
                if (next) BLACK_ALL else BLACK_WHITE
            } else {
                if (next) WHITE_BLACK else WHITE_ALL
            }
        }.joinToString(""))
    }

}



