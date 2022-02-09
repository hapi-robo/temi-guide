#!/bin/sh
#
# Converts a certificate (.crt) to Android certificate (.0)
#
# usage: androidCertificate.sh <filename> <output>
#
# positional arguments:
#
#   filename             Path to certificate (.crt)
#   output               Path to output
#
#

# Abort if any command fails
set -e

# Display usage instructions
usage()
{
  echo ""
  echo "usage: androidCertificate.sh <filename>"
  echo ""
  echo "Converts a certificate (.crt) to Android certificate (.0)"
  echo ""
  echo "positional arguments:"
  echo ""
  echo "  filename             Path to certificate (.crt)"
  echo "  output               Path to output"
  echo ""
  exit 1
}

# Check for input certificate file (.crt)
if [ -z "$1" ]; then
  echo "Missing certificate file (.crt)"
  usage
  exit 1
else
  FILENAME=$1
fi

# Get the hash of the certificate
HASH="$(openssl x509 -inform PEM -subject_hash_old -in ${FILENAME} | head -1)"

# The hash, appended with .0 (dot zero), will be used as the filename for the Android certificate
cat "${FILENAME}" > "${HASH}.0"
openssl x509 -inform PEM -text -in "${FILENAME}" -noout >> "${HASH}.0"

# Done
echo "Android Certificate Filename:"
echo "${HASH}.0"
echo ""

# Verify the certificate againt a known md5sum, sha1sum, and/or sha256sum
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

# Move file to output folder
if [ -z "$2" ]; then
  exit 0
else
  # Move file silently
  mv "${HASH}.0" "$2" 2>/dev/null
fi

exit 0