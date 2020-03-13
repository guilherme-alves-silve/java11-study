#Compile source folder with multiple source modules in the same folder
#JAVAC -D <the-output-folder> --module-source-path <multi-module-main-src-folder> <path-to-each-java-file>
javac -d out --module-source-path src src/data.access/module-info.java src/data.access/com/example/data/DataUtil.java \
			src/ui.app/module-info.java src/ui.app/com/example/app/AppMain.java
java --module-path out --module ui.app/com.example.app.AppMain