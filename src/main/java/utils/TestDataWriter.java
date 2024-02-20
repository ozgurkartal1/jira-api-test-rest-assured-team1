package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestDataWriter {

    @SneakyThrows
    public static void dataWriter(Object object, String path) {
        ObjectMapper mapper = new ObjectMapper();

        FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/test" +
                "/resources/test_data/" + path);

        mapper.writeValue(fileOutputStream, object);
    }
}
