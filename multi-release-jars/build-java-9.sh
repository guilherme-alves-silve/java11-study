#First change to java 9 or later and then execute this file
find my-lib-9/src/ -name *.java > my-lib-9/source-java-9.txt
javac -d my-lib-9/out @my-lib-9/source-java-9.txt