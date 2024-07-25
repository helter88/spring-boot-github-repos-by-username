import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Test;

class KarateTestRunner {
    @Karate.Test
    Karate testGithub() {
        return Karate.run().relativeTo(getClass());
    }
}
