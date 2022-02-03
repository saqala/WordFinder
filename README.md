# to run the app
# change /home/y/Downloads/google-10000-english.txt to point to your file path
mvn clean install && mvn exec:java -Dexec.args="/home/y/Downloads/google-10000-english.txt optonocear"
# sql test
sql test under resources/script