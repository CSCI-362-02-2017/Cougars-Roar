#! /bin/bash/python
import webbrowser

import os.path
fileLocationPath = os.path.dirname(os.path.abspath('__file__'))
print(fileLocationPath)
if os.path.split(os.path.abspath(fileLocationPath))[0] == '/':
    topLevelContents = os.listdir(fileLocationPath)
else:
    while os.path.split(os.path.abspath(fileLocationPath))[0] != '/':
        fileLocationPath = os.path.split(os.path.abspath(fileLocationPath))[0]
      
    topLevelContents = os.listdir(fileLocationPath)


f = open('myList.html','w')
message = """<html>
<head></head>
<body><p>
{topLevelContents}
</p></body>
</html>""".format(topLevelContents = topLevelContents)

f.write(message)
f.close()

webbrowser.open_new_tab('myList.html')
