/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custome;

/**
 *
 * @author penpen1112003
 */
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;

public class HDFSFileUploader {

    public static void main(String[] args) {
        // Check if the right number of arguments is provided
        if (args.length != 2) {
            System.out.println("Usage: HDFSFileUploader <local-file-path> <hdfs-destination-path>");
            System.exit(1);
        }

        String localFilePath = args[0];
        String hdfsDestinationPath = args[1];

        Configuration configuration = new Configuration();
        FileSystem fs = null;

        try {
            // Get the HDFS filesystem
            fs = FileSystem.get(configuration);

            // Define the source and destination paths
            Path localPath = new Path(localFilePath);
            Path hdfsPath = new Path(hdfsDestinationPath);

            // Check if the local file exists
            File localFile = new File(localFilePath);
            if (!localFile.exists()) {
                System.err.println("Local file does not exist: " + localFilePath);
                System.exit(1);
            }

            // Upload the file to HDFS
            fs.copyFromLocalFile(localPath, hdfsPath);
            System.out.println("File uploaded successfully to HDFS: " + hdfsDestinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the filesystem
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
