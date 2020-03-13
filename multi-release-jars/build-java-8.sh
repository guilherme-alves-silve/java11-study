#First change to java 8 and then execute this file
find my-lib-8/src/ -name *.java > my-lib-8/source-java-8.txt
javac -d my-lib-8/out @my-lib-8/source-java-8.txt
java -classpath my-lib-8/out/ com.example.Main