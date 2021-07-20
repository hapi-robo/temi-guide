#!/bin/sh
#
# Converts PKCS#12 (.pfx or .p12) to a certificate (.crt)
#
# usage: p12toCrt.sh <filename>
#
# positional arguments:
#
#   filename             Path to .p12 file
#
#

# abort if any command fails
set -e

# display usage instructions
usage()
{
  echo ""
  echo "usage: p12toCrt.sh <filename>"
  echo ""
  echo "Converts PKCS#12 (.pfx or .p12) to a certificate (.crt)"
  echo ""
  echo "positional arguments:"
  echo ""
  echo "  filename             Path to PKCS#12 (.pfx or .p12) file"
  echo ""
  exit 1
}

# check for .p12 name
if [ -z "$1" ]; then
  echo "Missing PKCS#12 (.pfx or .p12) file"
  usage
  exit 1
else
  FILENAME=$1
  NAME="$(echo "${FILENAME}" | cut -f 1 -d '.')"
fi

# convert .p12 to .crt
openssl pkcs12 -in ${FILENAME} -clcerts -nokeys -out ${NAME}.crt

# done
echo ${NAME}.crt
exit 0