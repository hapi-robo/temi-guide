#!/bin/sh
#
# Converts a certificate (.crt) to Android certificate (.0)
#
# usage: androidCertificate.sh <filename>
#
# positional arguments:
#
#   filename             Path to certificate (.crt)
#
#

# abort if any command fails
set -e

# display usage instructions
usage()
{
  echo ""
  echo "usage: androidCertificate.sh <filename>"
  echo ""
  echo "Converts a certificate (.crt) to Android certificate (.0)."
  echo ""
  echo "positional arguments:"
  echo ""
  echo "  filename             Path to certificate (.crt)"
  echo ""
  exit 1
}

# check for .p12 name
if [ -z "$1" ]; then
  echo "Missing certificate file (.crt)"
  usage
  exit 1
else
  FILENAME=$1
fi

# get the hash of the certificate
HASH="$(openssl x509 -inform PEM -subject_hash_old -in ${FILENAME} | head -1)"

# the hash, appended with .0 (dot zero), will be used as the filename for the Android certificate
cat "${FILENAME}" > "${HASH}.0"
openssl x509 -inform PEM -text -in "${FILENAME}" -noout >> "${HASH}.0"

# done
echo "Android Certificate Filename:"
echo "${HASH}.0"
echo ""

# verify the certificate againt a known md5sum, sha1sum, and/or sha256sum
echo "-----------------------------"
echo "Verification"
echo "-----------------------------"

echo "md5sum:"
md5sum "${HASH}.0"
echo ""

echo "sh1sum:"
sha1sum "${HASH}.0"
echo ""

echo "sha256sum:"
sha256sum "${HASH}.0"
echo ""

exit 0