# Cougars-Roar

## **Overview**

A testing framework for Tanaguru's Contrast Finder

---
## **Framework Directory Structure and Descriptions**

```
Cougar-Roar/
    TestAutomation/
        docs/ #nothing yet
        oracles/ #nothing yet (testCases acts as an oracle)
        project/ #contains Tanaguru's Contrast-Finder source code
            /src
            /bin
        reports/ #contains the output of testcases in a html format
            report.html
        scripts/ #contains the runAllTests script which activates the Drivers and manages files
            runAllTests.sh
        temp/ #contains individual test case reports which are appended into the reports.html
        testCases/ #contains 25 test case files which contain passabke values for the drivers
        testCasesExecutables/ #contains 
            ContrastCheckerDriver.java
    README.md
    Makefile
```
---
## **How to Execute Testing**

```
git clone

cd Cougars-Roar

make run
```
**if you get the following error:**

```
./runAllTests.sh: line 10: javac: command not found

./runAllTests.sh: line 10: javac: command not found

cat: '../temp/*': No such file or directory
```

**make sure you have java installed by doing:**

```
java -version
```

**If it does not recognize the command:**

```
sudo apt-get install default-jdk
```
