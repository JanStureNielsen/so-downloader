# Stackoverflow File Downloader Example

This is a simple file download program using just the JDK for a [Stackoverflow question](https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java/47598360#47598360). 

## Building

Build the runnable JAR with Maven:

```
mvn package
```

## Running

To run file download program:

```
java -jar so-downloader.jar <source-URL> <target-filename>
```

for example:

```
java -jar so-downloader.jar https://github.com/JanStureNielsen/so-downloader/archive/main.zip so-downloader-source.zip
```
