# Compilation:

 mkdir lib target   # javac for java 8 DOES NOT create the directory, however it is required by subject.
    # this command compiles .java files into .class files, put them into target directory
 javac -cp ".:./lib/JColor-5.0.0.jar:./lib/jcommander-1.78.jar" -d ./target/ src/java/edu/school21/printer/*/*.java

    # this command unpacks lib jar files to target folder, keeping packages and subdir
 cd target ; jar xf ../lib/JColor-5.0.0.jar com ; jar xf ../lib/jcommander-1.82.jar com ; cd ..

 cp -r src/resources target/.   # required by subject

# Jar file creation:
 rm -f ./target/images-to-chars-printer.jar #if not deleted, there will be a Invalid or corrupt jarfile error
    # this command packs .class files, resources and a manifest file into a single images-to-chars-printer.jar file
 jar -cvfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

    # OPTIONAL: this command will display contents of the manifest file
# unzip -q -c ./target/images-to-chars-printer.jar META-INF/MANIFEST.MF

# Launch jar application:
 java -jar target/images-to-chars-printer.jar