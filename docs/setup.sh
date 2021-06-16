#!/bin/sh
#
# Auto-generate python virtual environments and install requirements.
#
# Usage
#	  ./setup.sh
#

VENV_PATH="venv"

# If path does not exist, generate a new virtual environment
if [ ! -d "${VENV_PATH}" ]; then
    PYTHON=`which python3`

    if [ ! -f "${PYTHON}" ]; then
        echo "Could not find Python"
    fi
    python3 -m venv venv/
fi

# Activate the virtual environment
. "${VENV_PATH}/bin/activate"

# Install requirements
pip install -r requirements.txt
