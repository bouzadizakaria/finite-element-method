find . -name "*.java" | xargs javac -cp .:la4j.jar
java -cp .:la4j.jar demo/Demo3
#java -cp .:la4j.jar Main
