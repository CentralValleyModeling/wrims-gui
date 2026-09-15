import os

from hec.heclib.dss import DSSPathname, HecDss
from hec.io import TimeSeriesContainer
from java.util.regex import Pattern


def read_series_pair(filename, wsi_variable, di_variable):
    if not os.path.isfile(filename):
        raise IOError('DSS file does not exist: ' + filename)
    dss = HecDss.open(filename)
    try:
        manager = dss.getDataManager().dataManager()
        catalog = manager.getCatalog(True, None)
        # Match logical series across date blocks, without scanning every record.
        references = manager.getCondensedCatalog(catalog, False)
        result = []
        for variable in (wsi_variable, di_variable):
            pattern = Pattern.compile('^' + variable + '$')
            paths = [ref.getFirstPathname() for ref in references
                     if pattern.matcher(DSSPathname(ref.getFirstPathname()).getBPart()).matches()]
            if len(paths) != 1:
                raise ValueError("Expected one DSS series for '%s'; found %d" %
                                 (variable, len(paths)))
            series = dss.get(paths[0], True)
            if not isinstance(series, TimeSeriesContainer) or series.numberValues <= 0:
                raise ValueError('Expected nonempty time-series data: ' + paths[0])
            result.append(list(series.values[:series.numberValues]))
        return result[0], result[1]
    finally:
        dss.close()
