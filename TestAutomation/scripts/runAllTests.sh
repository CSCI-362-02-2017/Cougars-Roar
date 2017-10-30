#!/bin/bash
# runAllTests.sh
# Written by Julian Smith

# A shell script to execute multiple test case executables
rm -f ../reports/*
#prevents repeating old reports

cd ../testCasesExecutables/
javac -classpath . *.java
#allows for files to be executed
for file in ../testCasesExecutables/*
do
if [ ${file: -6} == ".class" ]; then
  fileonly=$(basename $file)
  name=$(echo "$fileonly" | cut -f 1 -d '.')
  java "${name}"
fi
done
#executes files
printf "<TABLE BORDER='5' CELLPADDING='4' CELLSPACING='3'>\n" >> ../reports/report.html
printf "<TR>\n" >> ../reports/report.html
printf "</TR>\n" >> ../reports/report.html
printf "<TR>\n" >> ../reports/report.html
printf "<TH>Test Case ID</TH>\n" >> ../reports/report.html
printf "<TH>Method</TH>\n" >> ../reports/report.html
printf "<TH>Description</TH>\n" >> ../reports/report.html
printf "<TH>fgColor</TH>\n" >> ../reports/report.html
printf "<TH>bgColor</TH>\n" >> ../reports/report.html
printf "<TH>Expected</TH>\n" >> ../reports/report.html
printf "<TH>Actual</TH>\n" >> ../reports/report.html
printf "<TH>Test Passed?</TH>\n" >> ../reports/report.html
printf "</TR>\n" >> ../reports/report.html
for file in ../temp/*
do
  printf "<TR ALIGN='CENTER'>\n" >> ../reports/report.html
  cat "$file" >> ../reports/report.html
  printf "</TR>\n" >> ../reports/report.html
done
printf "</TABLE>" >> ../reports/report.html
firefox ../reports/report.html || open ../reports/report.html
#adds to and opens report document
rm -f ../testCasesExecutables/*.class
rm -f ../temp/*
#removes all temps
