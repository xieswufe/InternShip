def convertTime(timeStr):
    '''
    convert time string '10a' or '10:30' to int 1000 or 1030
    '''
    base = 1200
    if timeStr[-1] == 'a':
        base = 0
        timeStr = timeStr[:-1]

    if ':' in timeStr:
        hr, min = map(int, timeStr.split(':'))
    else:
        min = 0
        hr = int(timeStr)

    return hr * 100 + min
