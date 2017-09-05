#! /bin/bash/python
import webbrowser
import os.path

fileLocationPath = os.path.dirname(os.path.abspath('__file__'))
fileLocationPathStatic = os.path.dirname(os.path.abspath('__file__'))
while os.path.split(os.path.abspath(fileLocationPath))[0] != '/':
    fileLocationPath = os.path.split(os.path.abspath(fileLocationPath))[0]
#splits down to top level directory if not in root directory
topLevelContents = os.listdir(fileLocationPath)

topLevelContentsFormatted = "\n\t- ".join(topLevelContents)


f = open('myList.html','w')
message = """<html>
    <head></head>
    <body><pre><h1>
    The contents of {fileLocationPath} are as follows:
        - {topLevelContentsFormatted}
    </h1></pre></body>
    </html>""".format(fileLocationPath = fileLocationPath, topLevelContentsFormatted = topLevelContentsFormatted)

f.write(message)
f.close()
new_tab = 'file://' + fileLocationPathStatic + '/myList.html'
#format needed for opening new tab
webbrowser.open_new_tab(new_tab)

