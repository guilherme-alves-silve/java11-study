jar --create --file my-lib.jar -C my-lib-8/out . --release 9 -C my-lib-9/out .
jar --list --file my-lib.jar
java -cp my-lib.jar com.example.Main