#!/bin/sh
#
# Converts PKCS#12 (.pfx or .p12) to a certificate (.crt)
#
# usage: p12toCrt.sh <filename>
#
# positional arguments:
#
#   filename             Path to .p12 file
#   output               Path to output
#

# Abort if any command fails
set -e

# Display usage instructions
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
  echo "  output               Path to output"
  echo ""
  exit 1
}

# Check for PKCS#12 file (.p12)
if [ -z "$1" ]; then
  echo "Missing PKCS#12 (.pfx or .p12) file"
  usage
  exit 1
else
  FILENAME=$1
  NAME="$(echo "${FILENAME}" | cut -f 1 -d '.')"
fi

# Convert .p12 to .crt
openssl pkcs12 -in ${FILENAME} -clcerts -nokeys -out ${NAME}.crt

# Done
echo ${NAME}.crt

# Move file to output folder
if [ -z "$2" ]; then
  exit 0
else
  # Move file silently
  mv "${NAME}.crt" "$2" 2>/dev/null
fi

exit 0