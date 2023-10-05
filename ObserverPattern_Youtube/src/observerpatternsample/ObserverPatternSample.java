/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package observerpatternsample;

import observerpatternsample.model.VideoUpload;
import observerpatternsample.channel.YoutubeChannel;
import observerpatternsample.service.Subscriber;

import java.util.Date;

public class ObserverPatternSample {

    public static void main(String[] args) {
        // Khai báo youtube channel
        YoutubeChannel youtubeChannel = new YoutubeChannel("Thinh Youtube");

        // Khai báo người đăng ký youtube channel "Thinh Youtube"
        Subscriber subscriber = new Subscriber(youtubeChannel);

        System.out.println("------------------------------- START -------------------------------");

        // Upload video mới, nếu đánh dấu star thì sẽ tự động gửi thông báo tới người đăng ký.
        VideoUpload doraemonSpecial = new VideoUpload("Tập doraemon đặc biệt !", "Một ngày sinh nhật rỗng túi của suneo ", new Date(), true);
        youtubeChannel.uploadVideo(doraemonSpecial);

        System.out.println("-------------------------------- END --------------------------------");
    }

}
