[![](https://jitpack.io/v/walleth/console-barcodes.svg)](https://jitpack.io/#walleth/console-barcodes)

What?
=====

Prints QR-Codes on the terminal.

Why?
====

I want to use it to connect [geth](https://github.com/ethereum/go-ethereum) and [WallETH](https://walleth.org) via the [wallet connect](https://walletconnect.org) protocol.

How?
====

It uses [zxing](https://github.com/zxing/zxing) and is inspired by [qrcode-terminal](https://github.com/gtanner/qrcode-terminal)

Usage
=====

If not already done add the jitpack repository:

```groovy
allprojects {
   repositories {
      maven { url 'https://jitpack.io' }
   }
}
```

Then add console-barcodes:lib as a dependency:

```groovy
dependencies {
   implementation 'com.github.walleth.console-barcodes:lib:<version>'
}
```

Now you can use the library:

```kotlin
 printQR( "Hello world" )
```

License
=======

MIT