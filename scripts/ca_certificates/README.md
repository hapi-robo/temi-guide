# Installing Android CA System Certificates

## Prerequisites
You will need a linux system with `openssl`.


## Converting PKCS#12 to a Certificate
Convert PKCS#12 (`.pfx` or `.p12`) to a certificate (`.crt`):
```
./p12toCrt.sh <filename>.p12
```

Alternatively, you can do this the long way:
```
openssl pkcs12 -in <filename>.p12 -clcerts -nokeys -out <filename>.crt
```

For testing, you can create your own PKCS#12 file [here](https://pkijs.org/examples/PKCS12SimpleExample.html).


## Creating Android System Certificate
Convert certificate (`.crt`) to an Android certificate (`.0`):
```
./androidCertificate <filename>.crt
```

Alternatively, you can do this the long way. First, get the `hash` of the certificate:
```
openssl x509 -inform PEM -subject_hash_old -in <filename>.crt | head -1
```

The `hash`, appended with `.0` (dot zero), will be used as the filename for the Android system certificate:
```
cat <filename>.crt > <hash>.0
openssl x509 -inform PEM -text -in <filename>.crt -noout >> <hash>.0
```

You can verify the certificate againt a known `md5sum`, `sha1sum`, and/or `sha256sum` as follows:
```
md5sum <hash>.0
sha1sum <hash>.0
sha256sum <hash>.0
```

For testing, you can use the `.crt` files in the `assets` folder, which are taken from [here](https://www.cacert.org/index.php?id=3).


## Copying an Android System Certificate to your Device
Push the file to your Android device's certificates directory using `adb`:
```
adb push <hash>.0 /sdcard/
adb shell
su
mount -o remount,rw /system
cp /sdcard/<hash>.0 /system/etc/security/cacerts/
```

Adjust the file permissions:
```
cd /system/etc/security/cacerts/
chmod 644 <hash>.0
```

Double-check the file permissions:
```
ls -al
```

File permissions should look like:
```
-rw-r--r--
```

Reboot the device.
```
reboot
```


## Reference:
* http://wiki.cacert.org/FAQ/ImportRootCert#Android_Phones_.26_Tablets
* https://security.stackexchange.com/questions/183072/pem-cer-crt-p12-what-is-it-all-about
* https://www.sslshopper.com/article-most-common-openssl-commands.html
