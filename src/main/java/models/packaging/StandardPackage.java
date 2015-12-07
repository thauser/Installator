package models.packaging;

import models.packaging.utils.SizeFileWalker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunderhi on 30/11/15.
 * This is the base implementation of the package class. It stores information about where a package is
 * located, and where it is unpacked to. It unpacks from the "packages" folder of the current jar it is
 * executing in.
 */

public class StandardPackage extends Package {

    private List<Path> excludes = new ArrayList();
    private Path rootPath;
    private FileSystem jarFileSystem;
    private long size;

    public StandardPackage(String packageName) {
        String jarFilePath = getRunningJarLocation();
        jarFileSystem = getJarFileSystem(jarFilePath);
        rootPath = jarFileSystem.getPath("packages", packageName);
        size = calculatePackageSize();
        System.out.println(size);
    }

    private String getRunningJarLocation() {
        try {
            return getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        }
        catch(URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private FileSystem getJarFileSystem(String jarPath) {
        FileSystem fs = null;
        Path jar = Paths.get(jarPath);

        try {
            fs = FileSystems.newFileSystem(jar, null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return fs;
    }

    private long calculatePackageSize() {
        SizeFileWalker sizeCalculator = new SizeFileWalker();
        try {
            Files.walkFileTree(rootPath, sizeCalculator);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return sizeCalculator.getSize();
    }

    public long getSize() {
        return size;
    }

    public void addExclude(String excludePathName) {
        Path excludePath = jarFileSystem.getPath(rootPath.toString(), excludePathName);
        excludePath = excludePath.toAbsolutePath();
        excludes.add(excludePath);
    }

    public List<Path> getExcludes() {
        return excludes;
    }

    public Path getRootPath() {
        return rootPath;
    }

    @Override
    public void notifyListeners(Object message) {}

}
