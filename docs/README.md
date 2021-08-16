# Usage
Make document (default: English)
```
make html
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