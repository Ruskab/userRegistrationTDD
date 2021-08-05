package ikab.tdd.tdduserregistration.fake;

import ikab.tdd.tdduserregistration.IdGenerator;

import java.nio.charset.StandardCharsets;

public class FakeIdGenerator implements IdGenerator {

    private String generatedId;

    @Override
    public String generatedId() {
        generatedId = new String(new byte[7], StandardCharsets.UTF_8);
        return generatedId;
    }

    public String getGeneratedId() {
        return generatedId;
    }
}
