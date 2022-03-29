package file.filehandler.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
public class FileHandlerController {

    @GetMapping("/hello")
    public String quickTest(){
        return "Hello World";
    }

    @GetMapping("/file-handler/byte-string")
    public String GetFile() throws IOException {
        String fileAbsolutePath = "insert file path;

        File file = new File(fileAbsolutePath);

        FileInputStream fl = new FileInputStream(file);

        // Now creating byte array of same length as file
        byte[] arr = new byte[(int)file.length()];

        // Reading file content to byte array
        // using standard read() method
        fl.read(arr);

        // lastly closing an instance of file input stream
        // to avoid memory leakage
        fl.close();

        // Returning above byte array
        return Base64.getEncoder().encodeToString(arr);

    }
}
