import os.path
fileLocationPath = os.path.dirname(os.path.abspath('__file__'))
print(fileLocationPath)
if os.path.split(os.path.abspath(fileLocationPath))[0] == '/':
    topLevelContents = os.listdir(fileLocationPath)
else:
    while os.path.split(os.path.abspath(fileLocationPath))[0] != '/':
        fileLocationPath = os.path.split(os.path.abspath(fileLocationPath))[0]
        print(fileLocationPath)
    topLevelContents = os.listdir(fileLocationPath)
print(topLevelContents)
