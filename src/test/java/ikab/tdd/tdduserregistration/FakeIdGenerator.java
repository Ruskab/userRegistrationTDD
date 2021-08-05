package ikab.tdd.tdduserregistration;

import java.nio.charset.StandardCharsets;

public class FakeIdGenerator implements IdGenerator {
    @Override
    public String generateId() {
        return new String(new byte[7], StandardCharsets.UTF_8);
    }
}
