package utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.poi.ss.formula.functions.T;

import java.io.FileInputStream;
import java.util.List;

public class TestDataReader {

    @SneakyThrows
    public static <T> T dataReader(String path, Class<T> typeValue){
        ObjectMapper mapper = new ObjectMapper();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/test_data/" + path);

        return mapper.readValue(fileInputStream, typeValue);
    }
}
