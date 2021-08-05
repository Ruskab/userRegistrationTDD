package ikab.tdd.tdduserregistration.infrastructure;


import ikab.tdd.tdduserregistration.domain.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RealIdGenerator implements IdGenerator {


    @Override
    public String generatedId() {
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8).concat(String.valueOf(LocalDateTime.now(ZoneId.systemDefault()).toEpochSecond(ZoneOffset.UTC)));
    }
}
