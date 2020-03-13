echo "Building project..."
find src/ -name *.java
find src/ -name *.java > source.txt
echo "Compiling project..."
javac -d out @source.txt
echo "Executing project..."
java -classpath out com.logicbig.example.TryWithResourceExample
echo "Finished!"