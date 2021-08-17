# Usage
Make document (default: English)
```
make html
```

Extract document's translatable messages into pot (.po) files
```
make gettext
```
This invokes the sphinx gettext builder that generates pot files under `build/gettext` folder.

Update your local pot files:
```
sphinx-intl update -p build/gettext -l ja
```

Make translated document
```
make -e SPHINXOPTS="-Dlanguage='ja'" html
```

## Tips
For empty strings, use ['ZERO WIDTH SPACE' (U+200B)](https://stackoverflow.com/a/14414266). Copy this character from [here](https://unicode-table.com/en/200B/).

## References
- [Localization Quickstart](https://sphinx-intl.readthedocs.io/en/master/quickstart.html)
- [RTD Localization of Documentation](https://docs.readthedocs.io/en/stable/localization.html)
- [RTD Structure Elements](https://sphinx-rtd-theme.readthedocs.io/en/stable/demo/structure.html)