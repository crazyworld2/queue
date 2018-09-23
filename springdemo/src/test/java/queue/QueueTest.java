package queue;


import com.example.queue.CustomJobDetail;
import com.example.queue.api.QueueApi;
import com.example.queue.consume.JobComsume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc.xml"})
public class QueueTest {

    @Autowired
    QueueApi api;
    @Autowired
    JobComsume consume;

    @Test
    public void test0()throws Exception{
        //创建100个任务并添加到队列
        for (int i = 0; i < 100; i++) {
            CustomJobDetail customJobDetail=new CustomJobDetail();
            customJobDetail.setJobName("任务【"+i+"】");
            api.newJob(JobDemo.class,customJobDetail);
        }
        //运行消费者
        consume.start();
        Thread.sleep(10);
        //暂停消费者
        new Thread(new Runnable() {
            public void run() {
                consume.pauseJob();
            }
        }).start();
        Thread.sleep(6000);
        //恢复消费者线程
        new Thread(new Runnable() {
            public void run() {
                consume.resumeJob();
            }
        }).start();
        Thread.sleep(10);
        //再次暂停消费者
        new Thread(new Runnable() {
            public void run() {
                consume.pauseJob();
            }
        }).start();
        Thread.sleep(100*1000L);

    }

}