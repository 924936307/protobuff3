import com.bobo.learning.protobuf.message.BatteryData;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

/**
 * Created with IntelliJ IDEA.
 * User: bobo
 * Date: 2019/9/5
 * Description: https://blog.csdn.net/u010398771/article/details/82077915
 */
public class MyTest {


    /**
     * protobuf是一种数据交换的格式，以二进制的格式进行数据交换，主要用于网络传输、配置文件、
     * 数据存储等诸多领域
     * 下面我们就将指定格式的信息转换成字节形式数据，然后将字节形式数据恢复成指定格式的信息
     * 读者可以简单的看下.proto文件生成的BatteryData类的结构
     */
    public static void main(String[] args) {
        //建造者模式  序列化--》二进制格式
        BatteryData.gps_data.Builder builder = BatteryData.gps_data.newBuilder();
        builder.setId(1l);
        builder.setAltitude(1);
        builder.setDataTime("2017-12-17 16:21:44");
        builder.setGpsStatus(1);
        builder.setLat(39.123);
        builder.setLon(120.112);
        builder.setDirection(30.2F);
        builder.setId(100L);
        BatteryData.gps_data gps_data = builder.build();
        System.out.println("gps_data = " + gps_data);
        byte[] bytes = gps_data.toByteArray();
        System.out.println("bytes = " + bytes);
        System.out.println("bytes = " + bytes.length);
        //反序列化
        BatteryData.gps_data gd= null;
        try {
            gd = BatteryData.gps_data.parseFrom(bytes);
            String print = JsonFormat.printer().print(gd);
            System.out.println("print = " + print);
            System.out.println("print.length() = " + print.length());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
