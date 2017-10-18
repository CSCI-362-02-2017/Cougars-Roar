#!/bin/bash
# runAllTests.sh
# Written by Julian Smith

# A shell script to execute multiple test case executables
rm -f ../reports/*
#prevents repeating old reports
for file in ../testCasesExecutables/*
do
  javac "$file"
done
cd ../testCasesExecutables/
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
for file in ../temp/*
do
  printf "<p>" >> ../reports/report.html
  cat "$file" >> ../reports/report.html
  printf "</p>\n" >> ../reports/report.html
done
open ../reports/report.html
#adds to and opens report document
rm -f ../testCasesExecutables/*.class
rm -f ../temp/*
#removes all temps