package models.packaging.utils;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by eunderhi on 04/12/15.
 */
public class SizeFileWalker extends SimpleFileVisitor<Path> {

    private long size = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        size += attr.size();
        return FileVisitResult.CONTINUE;
    }

    public long getSize() {
       return size;
    }

}
