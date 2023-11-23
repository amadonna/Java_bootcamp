#Инструкции по компиляции и запуску приложения ImagesToChar:

# удалить директорию target
rm -rf target

#скомпилировать классы и определить в директории target
javac -d ./target src/java/edu/school21/printer/*/*.java

#запустить приложение
java -cp target edu.school21.printer.Program . 0 /Users/elodiawy/goinfre/it.bmp