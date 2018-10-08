package org.walleth.console.barcodes

import com.google.zxing.BarcodeFormat.QR_CODE
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

fun printQR(content: String, large: Boolean = false) {

    val writer = QRCodeWriter().encode(content, QR_CODE, 0, 0)

    if (large) {
        writer.printLarge()
    } else {
        writer.printSmall()
    }
}

private const val WHITE_2x2 = "\u2588\u2588"
private const val BLACK_2x2 = "  "

fun BitMatrix.printLarge() {

    for (y in 0 until height) {
        println((0 until width).joinToString("") { x ->
            if (get(x, y)) BLACK_2x2 else WHITE_2x2
        })
    }

}

private const val WHITE_ALL_1x1 = '\u2588'
private const val WHITE_BLACK_1x1 = '\u2580'
private const val BLACK_WHITE_1x1 = '\u2584'
private const val BLACK_ALL_1x1 = ' '

private fun BitMatrix.printSmall() {
    for (y in 0 until height step 2) {
        println((0 until width).map { x ->
            val nextRowPixel = (y + 1 < height) && get(x, y + 1)
            if (get(x, y)) {
                if (nextRowPixel) BLACK_ALL_1x1 else BLACK_WHITE_1x1
            } else {
                if (nextRowPixel) WHITE_BLACK_1x1 else WHITE_ALL_1x1
            }
        }.joinToString(""))
    }
}