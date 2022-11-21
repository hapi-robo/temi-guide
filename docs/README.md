# temi Guide Documentation

## Prerequisites
### Python
This repository has been tested on version [3.8.10](https://www.python.org/downloads/release/python-3810/).

On Windows, install using the Windows installer provided on [www.python.org](https://www.python.org/). Avoid using the version of Python available from Windows Marketplace.


## Setup
### Linux
```shell
./setup.sh
```

### Windows PowerShell
Create a virtual environment:
```shell
python -m venv venv/
```

Activate the virtual environment:
```shell
.\venv\Scripts\activate
```

To disable the virtual environment:
```shell
deactivate
```

With an active virtual environment, install project requirements:
```shell
pip install -r requirements.txt
```


## Usage
### Linux
Make document (default: English)
```shell
make html
```

Extract document's translatable messages into pot (.po) files
```shell
make gettext
```
This invokes the sphinx gettext builder that generates pot files under `build/gettext` folder.

Update your local pot files:
```shell
sphinx-intl update -p build/gettext -l ja
```

Make translated document
```shell
make -e SPHINXOPTS="-Dlanguage='ja'" html
```


### Windows PowerShell
Make document (default: English)
```shell
mingw32-make html
```

Extract document's translatable messages into pot (.po) files
```shell
mingw32-make gettext
```
This invokes the sphinx gettext builder that generates pot files under `build/gettext` folder.

Update your local pot files:
```shell
sphinx-intl update -p build/gettext -l ja
```

Make translated document
```shell
mingw32-make -e SPHINXOPTS="-Dlanguage='ja'" html
```


## Tips
For empty strings, use ['ZERO WIDTH SPACE' (U+200B)](https://stackoverflow.com/a/14414266). Copy this character from [here](https://unicode-table.com/en/200B/).


## References
- [Localization Quickstart](https://sphinx-intl.readthedocs.io/en/master/quickstart.html)
- [RTD Localization of Documentation](https://docs.readthedocs.io/en/stable/localization.html)
- [RTD Structure Elements](https://sphinx-rtd-theme.readthedocs.io/en/stable/demo/structure.html)