javac -d out src/com/logicbig/MyClass.java src/module-info.java
#If the code access other modules (not the case)
#javac -d out --module-path <module_folder> src/com/logicbig/MyClass.java src/module-info.java
java --module-path out --module my.module/com.logicbig.MyClass
