echo "*** Long Mode File ***"
echo "Creating module-info.java files..."
echo "module common.widget { exports com.logicbig; }" > src/common.widget/module-info.java
echo "module data.widget { requires common.widget; }" > src/data.widget/module-info.java
echo "Creating file to compile common.widget..."
find src/common.widget -name *.java
find src/common.widget -name *.java > source1.txt
echo "Creating file to compile data.widget..."
find src/data.widget -name *.java
find src/data.widget -name *.java > source2.txt
echo "Compiling sources..."
javac -d out/common.widget @source1.txt
javac --module-path out -d out/data.widget @source2.txt
echo "Executing..."
java --module-path out --module data.widget/com.example.Component 
echo "Finished!"