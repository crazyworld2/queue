package queue;

import com.example.queue.CustomJob;
import com.example.queue.CustomJobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobDemo implements CustomJob {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void execute(CustomJobDetail jobDetail) {
        log.info(jobDetail.getJobName()+"。。。。。");
    }
}
