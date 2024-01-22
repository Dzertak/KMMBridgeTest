// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/Dzertak/KMMBridgeTest/com/kravchenko/kmmbridgetest/allshared-kmmbridge/0.1.1.0/allshared-kmmbridge-0.1.1.0.zip"
let remoteKotlinChecksum = "cfd0d14500a589b63e2cbe5c44a3c1d2f5197628ca7fbdf88d11c32a78d177f4"
let packageName = "allshared"
// END KMMBRIDGE BLOCK

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)